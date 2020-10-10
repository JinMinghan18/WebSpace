<%@ page import="cn.edu.zjut.model.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/10
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>登陆成功</title>
</head>
<body>
    <% UserBean user = (UserBean)(request.getAttribute("USER"));%>
    登陆成功，欢迎您，<%=user.getUsername()%>!
</body>
</html>
