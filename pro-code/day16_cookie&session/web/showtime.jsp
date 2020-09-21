<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/28
  Time: 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello,jsp!</title>
</head>
<body>
<input>
<%
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies.length != 0 && cookies != null) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("lastTime".equals(name)) {
                flag = true;
                String value = cookie.getValue();
                System.out.println("解码前：" + value);
                String s2 = URLDecoder.decode(value, "utf-8");
                System.out.println("解码后：" + s2);
                out.write("张夫业");
                response.getWriter().write("欢迎回来，您上次访问时间为:" + s2);
                Date date = new Date();
                SimpleDateFormat smp = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String s = smp.format(date);
                System.out.println("编码前：" + s);
                String s1 = URLEncoder.encode(s, "utf-8");
                System.out.println("编码后：" + s1);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                cookie.setValue(s1);
                response.addCookie(cookie);
                break;
            }
        }
    }
    if (cookies.length == 0 || cookies == null || flag == false) {
        Date date = new Date();
        SimpleDateFormat smp = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:SS");
        String s = smp.format(date);
        System.out.println("编码前：" + s);
        String s1 = URLEncoder.encode(s, "utf-8");
        System.out.println("编码后：" + s1);
        Cookie lastTime = new Cookie("lastTime", s1);
        lastTime.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(lastTime);
        response.getWriter().write("您好，欢迎您首次访问");
    }
%>
<input>
</body>
</html>
