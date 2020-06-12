<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/12
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息管理</title>
    <link rel="stylesheet" href="<%=path%>/CSS/HealthCodeLoginCSS.css">
</head>
<body style="background: #444444">
<div class="login">
    <div class="account">
        <form action="../StudentQueryServlet" method="post" onsubmit="return check_form();">
            <div class="logo">系统管理员信息管理界面</div>
            <div class="line">
                <input class="inputtxt" value name="college" id="college" datatype="*"
                       nullmsg="请填写学院" placeholder="学院" type="text">
            </div>
            <div class="line">
                <input class="inputtxt" name="major" id="major" type="text" placeholder="专业"
                       nullmsg="请输入专业" datatype="*">
            </div>
            <div class="line">
                <input class="inputtxt" name="class1" id="class1" type="text" placeholder="班级"
                       nullmsg="请输入班级" datatype="*">
            </div>
            <div class="login_btn">
                <input id="manage" value="信息管理" type="submit">
            </div>
        </form>
    </div>
</div>
</body>
</html>
