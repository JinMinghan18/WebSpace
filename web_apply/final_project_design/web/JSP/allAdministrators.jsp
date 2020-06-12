<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/10
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统管理员</title>
    <link rel="stylesheet" href="<%=path%>/CSS/HealthCodeLoginCSS.css">
</head>
<body style="background: #444444">
<div class="login">
    <div class="account">
        <form action="#" method="post" onsubmit="return check_form();">
            <div class="logo">系统管理员管理界面</div>
            <div class="login_btn">
                <input id="login-button" value="登录" type="submit">
            </div>
        </form>
    </div>
</div>
</body>
</html>
