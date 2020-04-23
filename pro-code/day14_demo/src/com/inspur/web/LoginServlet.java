package com.inspur.web;

import com.inspur.dao.UserLogin;
import com.inspur.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/22
 * @Description:
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置request的编码方式
//        request.setCharacterEncoding(“UTF-8”)的作用是设置对客户端请求和数据库取值时的编码，不指定的话使用iso-8859-1
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password=request.getParameter("password");
        User user2 = new User();
        user2.setName(username);
        user2.setPassword(password);
        request.setAttribute("user",user2);
        UserLogin user = new UserLogin();
        try {
            if (user.userLogin(user2)){
                request.getRequestDispatcher("./success").forward(request,response);
            }else{
                request.getRequestDispatcher("./fail").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
