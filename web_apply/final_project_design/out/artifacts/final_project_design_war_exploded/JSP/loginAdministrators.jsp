<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/10
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" href="../CSS/HealthCodeLoginCSS.css">
</head>
<body>
<body style="background: #444444">
<div class="login2">
    <div class="account">
        <form action="#" method="post" onsubmit="return check_form();">
            <div class="logo">管理员登录界面</div>
            <div class="line">
                <input class="inputtxt" name="account" id="account" datatype="*"
                       nullmsg="请填写账号" placeholder="工号" type="text">
            </div>
            <div class="line">
                <input class="inputtxt" name="password" id="password" type="password" placeholder="密码"
                       nullmsg="请输入密码" datatype="*">
            </div>
            <div class="login_btn">
                <input id="login-button" value="登录" type="submit">
            </div>
        </form>
    </div>
</div>
</body>
</body>
</html>
