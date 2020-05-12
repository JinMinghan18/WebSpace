<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/24
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login1</title>
    <script type="text/javascript" src="../js/checkform1.js"></script>
</head>
    <body>
        <div style="text-align: center;border: 1px solid #000000;width: 300px;margin-left: 40%;">
            <h4>登陆系统</h4>
            <form action="../LoginAction" method="post" name="form" onsubmit="return checkForm()">
                <table>
                    <tr>
                        <td>用户类型:</td><td><input type="radio" name="t1" value="stu" checked="checked">学生<input type="radio" name="t1" value="tea">老师</td>
                    </tr>
                    <tr>
                        <td>用户名:</td><td><input type="text" name="id"></td>
                    </tr>
                    <tr>
                        <td>用户密码:</td><td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="登陆"></td><td><input type="reset" value="重置"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
