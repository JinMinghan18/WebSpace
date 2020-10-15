<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/14
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="login" method="post">
    请输入用户名：<input name="loginUser.account" type="text"><BR>
    请输入密码：<input name="loginUser.password" type="password">
    <input type="submit" value="登录">
</form>
</body>
</html>
