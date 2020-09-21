package com.inspur.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/23
 * @Description:
 *  在服务器中的Servlet判断是否有一个名为lastTime的cookie
 *  1. 有：不是第一次访问
 *      1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 *      2. 写回Cookie：lastTime=2018年6月10日11:50:01
 *  2. 没有：是第一次访问
 *      1. 响应数据：您好，欢迎您首次访问
 *      2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/loginCookieServlet")
public class LoginCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag=false;
        if(cookies.length!=0&&cookies!=null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)){
                    flag=true;
                    String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    String s2 = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后："+s2);
                    response.getWriter().write("欢迎回来，您上次访问时间为:"+s2);
                    Date date=new Date();
                    SimpleDateFormat smp = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String s = smp.format(date);
                    System.out.println("编码前："+s);
                    String s1 = URLEncoder.encode(s, "utf-8");
                    System.out.println("编码后："+s1);
                    cookie.setMaxAge(60*60*24*30);
                    cookie.setValue(s1);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if(cookies.length==0||cookies==null||flag==false){
            Date date=new Date();
            SimpleDateFormat smp = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:SS");
            String s = smp.format(date);
            System.out.println("编码前："+s);
            String s1 = URLEncoder.encode(s, "utf-8");
            System.out.println("编码后："+s1);
            Cookie lastTime = new Cookie("lastTime", s1);
            lastTime.setMaxAge(60*60*24*30);
            response.addCookie(lastTime);
            response.getWriter().write("您好，欢迎您首次访问");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
