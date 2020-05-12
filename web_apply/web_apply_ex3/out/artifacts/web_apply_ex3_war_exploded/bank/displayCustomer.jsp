<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" class="bank.com.model.Customer" scope="session"/>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<h4>用户信息</h4>
<table>
    <tr>
        <td>邮箱：</td>
        <td><jsp:getProperty name="customer" property="email"/></td>
    </tr><br>
    <tr>
        <td>用户名：</td>
        <td><jsp:getProperty name="customer" property="custName"/></td>
    </tr><br>
    <tr>
        <td>电话：</td>
        <td><jsp:getProperty name="customer" property="phone"/></td>
    </tr>
</table>
</body>
</html>
