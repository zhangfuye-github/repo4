<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/19
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入门程序</title>
</head>
<body>
    <h1>程序入门</h1>
    <form action="users/testRequestParam">
        <span>姓名:</span><input name="uname" type="text"><br />
        <span>密码:</span><input name="password" type="text"><br />
        <span>生日:</span><input name="birthday" type="text"><br />
        <input type="submit" value="登录">
    </form>
</body>
</html>
