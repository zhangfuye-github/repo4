package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/15
 * @Description:
 */
@WebServlet("/registUserServlet")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.首先从获取表单的验证码
        String check = request.getParameter("check");
        //2.从session中获取存储的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        //3.移除验证码
        session.removeAttribute("CHECKCODE_SERVER");
        //4.进行验证码的比对
        ResultInfo resultInfo=new ResultInfo();
        if(!check.equalsIgnoreCase(checkcode_server)){
            //如果验证码，不正确，返回结果，验证码不正确的提示
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码不正确,请输入正确的验证码");
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return;
        }
        //验证码正确的话，进行用户注册
        //首先获取用户传递过来的参数

        Map<String, String[]> map = request.getParameterMap();
        //进行用户参数的封装通过使用一个类
        User user = new User();
        try {
            BeanUtils.populate(user,map);//通过使用工具类，将数据封装到user对象当中
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //调用service层注册用户的方法
        UserService service=new UserServiceImpl();
        boolean b = service.registUser(user);
        //根据返回的结果进行，参数的判断
        if(b){
            //true表示注册成功
            resultInfo.setFlag(true);
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return;
        }else{
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("该用户已被注册，请重新填写用户名");
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
