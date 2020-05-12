<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h4>用户登录</h4>
    <form action="../LoginServlet">
        <table>
            <tr>
                <td>邮箱：</td><td><input type="email" placeholder="请输入注册邮箱" name="email" id="email"></td>
            </tr>
            <tr>
                <td>密码：</td><td><input type="password" placeholder="请输入密码" name="password" id="password"></td>
            </tr>
            <tr><td><input type="submit" value="登录"></td><td><input type="reset" value="重置"></td></tr>
        </table>
    </form>
</body>
</html>
