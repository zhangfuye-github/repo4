package cn.itcast.web.servlet;

import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/22
 * @Description:
 */
@WebServlet("/delSelecteServlet")
public class DelSelecteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码格式
        request.setCharacterEncoding("utf-8");
        //2.获取上传的参数
        String[] ids = request.getParameterValues("uid");
//        System.out.println(ids.length);
//        for (int i = 0; i < ids.length; i++) {
//            System.out.println(ids[i]);
//        }
        UserService userService=new UserServiceImpl();
        userService.delSelectedUser(ids);
        //3.重定向到用户列表查询servlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
