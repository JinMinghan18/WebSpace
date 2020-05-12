<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/25
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userBean" class="com.demo.UserBean" scope="session"/>
<html>
<head>
    <title>教师</title>
</head>
<body>
    <jsp:getProperty name="userBean" property="name"/>老师，欢迎您！
</body>
</html>
