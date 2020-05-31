<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/29
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户信息</title>
</head>
<body>
    <table>
        <tr>
            <td>客户编号：</td>
            <td>${customer.cust_id}</td>
        </tr>
        <tr>
            <td>客户姓名：</td>
            <td>${customer.cname}</td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td>${customer.email}</td>
        </tr>
        <tr>
            <td>余额：</td>
            <td>${customer.balance}</td>
        </tr>
    </table>
</body>
</html>
