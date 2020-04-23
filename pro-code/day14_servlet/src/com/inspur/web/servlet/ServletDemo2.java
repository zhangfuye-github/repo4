package com.inspur.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/20
 * @Description:
 */
@WebServlet("/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("GBK");
        String name = req.getParameter("name");
        System.out.println("name:"+name);
        String password = req.getParameter("password");
        System.out.println("password:"+password);
        String[] hobbies = req.getParameterValues("hobbay");
        for (String hobby : hobbies) {
            System.out.println("hobby:"+hobby);
        }
        System.out.println("Get请求执行");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
