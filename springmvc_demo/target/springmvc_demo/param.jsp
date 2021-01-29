<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="test/param">
        <span>账户名:</span><input type="text" name="name">
        <span>金额:</span><input type="text" name="money">
        <span>用户名:</span><input type="text" name="user.name">
        <span>年龄:</span><input type="text" name="user.age">
        <span>账户名1:</span><input type="text" name="name11">
        <span>用户名1:</span><input type="text" name="user.name1">
        <input type="submit">
    </form>
</body>
</html>
