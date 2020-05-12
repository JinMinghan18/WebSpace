<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/25
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login2</title>
    <script src="/js/checkform1.js"></script>
</head>
<body>
    <div style="text-align: center;border: 1px solid #000000;width: 300px;margin-left: 40%;">
        <form action="../LoginAction2" method="post" onsubmit="return checkForm()">
            <h4>登陆系统</h4>
            <table>
                <tr>
                    <td>用户名:</td><td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td>密码:</td><td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="登陆"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
