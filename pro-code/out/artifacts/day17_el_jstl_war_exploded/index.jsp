<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itcast.test.web.User" %>
<%@ page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/30
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    ArrayList list = new ArrayList();
    list.add(new User("张三",13,new Date()));
    list.add(new User("李四",27,new Date()));
    list.add(new User("王五",19,new Date()));
    request.setAttribute("list",list);
  %>
  你好，世界！！！！！！！！！！！<br />
  <table>
    <c:forEach items="${list}" var="user" >



        <tr bgcolor="red">

          <td>${user.name}</td>
          <td>${user.age}</td>
          <td>${user.birStr}</td>
        </tr>


    </c:forEach>
  </table>
  </body>
</html>
