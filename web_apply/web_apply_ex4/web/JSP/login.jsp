<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/15
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="../login" method="post">
        <table>
            <tr><td>用户名:</td><td><input type="text" name="userName"/></td></tr>
            <tr><td>密码:</td><td><input type="password" name="password"/></td></tr>
            <tr><td colspan="2"><input type="submit" value="登录"/></td></tr>
        </table>
    </form>
</body>
</html>
