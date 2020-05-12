<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户信息录入</title>
</head>
<body>
    <a href="../bank/displayAllcustomer.jsp">显示所有注册客户信息</a><br>
    <a href="../bank/login.jsp">用户登录</a>

    <form action="../CustomerServlet" method="post">
        <table>
            <h4>客户信息录入</h4>
            <tr>
                <td>电子邮箱：</td><td><input type="email" name="email"/></td>
            </tr>
            <tr>
                <td>密码：</td><td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>用户名：</td><td><input type="text" name="custName"/></td>
            </tr>
            <tr>
                <td>电话：</td><td><input type="tel" name="phone"/></td>
            </tr>
            <tr><td><input type="submit"></td><td><input type="reset"></td></tr>
        </table>
    </form>
</body>
</html>
