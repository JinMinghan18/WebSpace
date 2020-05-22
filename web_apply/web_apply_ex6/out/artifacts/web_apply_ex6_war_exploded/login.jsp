<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/17
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="Login" method="post" name="loginForm">
        <table>
            <tr>
                <td colspan="2"><input type="radio" name="a1" value="student" checked="checked"/>学生
                    <input type="radio" name="a1" value="teacher">老师</td>
            </tr>
            <tr>
                <td>用户名：<input type="text" name="number" value="" /></td>
            </tr>
            <tr>
                <td>密码：<input type="password" value="" name="password" ></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
            <tr>
                <td><a href="register.jsp">注册</a></td>
            </tr>
        </table>

    </form>
</body>
</html>
