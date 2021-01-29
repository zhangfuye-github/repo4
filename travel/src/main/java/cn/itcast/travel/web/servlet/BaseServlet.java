package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/26
 * @Description:
 */
//@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    //作用：重写service实现方法的分发
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //1.获取用户的请求路径
        String uri = req.getRequestURI();  // /travel/user/add
//        System.out.println(uri);
        //2.获取要调用的方法名
        String methodName = uri.substring(uri.lastIndexOf("/") + 1); //add
//        System.out.println(methodName);
        //3.获取要调用的方法对象
//        System.out.println(this);       //谁调用我，我代表谁UserServlet@6ce851c5，地址值
        try {
            //忽略权限修饰符
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            //暴力反射
//            method.setAccessible(true);
            //4.执行要调用的方法
            method.invoke(this,req,res);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将结果封装成json，并返回到客户端
     * @param ob
     * @param res
     * @throws IOException
     */
    public void writeValue(Object ob,HttpServletResponse res) throws IOException {
        res.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(res.getWriter(),ob);
    }

    /**
     * 将结果封装成字符串，并返回给调用者
     * @param ob
     * @return
     * @throws JsonProcessingException
     */
    public String writeValue(Object ob) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(ob);
        return s;
    }

}
