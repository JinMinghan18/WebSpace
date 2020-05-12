<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/25
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userBean" class="com.demo.UserBean" scope="session"/>
<html>
<head>
    <title>学生</title>
</head>
<body>
    <jsp:getProperty name="userBean" property="name"/>同学，欢迎您
</body>
</html>
