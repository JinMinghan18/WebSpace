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
<div class="login2">
    <div class="account">
        <div class="logo">系统管理员管理界面</div>
        <form action="<%=path%>/JSP/SystemInfoManage.jsp" method="post">
            <div class="login_btn">
                <input id="manage" value="信息管理" type="submit">
            </div>
        </form>
        <form action="#" method="post">
            <div class="login_btn">
                <input id="" value="导入师生数据" type="submit">
            </div>
        </form>
        <form action="#" method="post">
            <div class="login_btn">
                <input id="数据查询" value="师生数据查询" type="submit">
            </div>
        </form>
    </div>
</div>
</body>
</html>
