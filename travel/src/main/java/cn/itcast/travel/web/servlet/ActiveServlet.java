package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/17
 * @Description:
 */
@WebServlet("/activeServlet")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.首先获取激活码
        String code = request.getParameter("code");
        //2.获取激活码之后，调用激活方法
        UserService service =new UserServiceImpl();
        boolean b=service.activeUser(code);
        if(b){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("激活成功，请<a href='login.html'>登录</a>");
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("激活失败");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
