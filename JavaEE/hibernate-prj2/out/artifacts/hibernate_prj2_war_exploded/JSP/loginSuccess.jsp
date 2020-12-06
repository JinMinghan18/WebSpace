<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:property value="#request.tip"/> 修改个人信息
    <s:form action="Userupdate" method="post">
        <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
        <s:textfield name="loginUser.account" label="用户名不能修改" value="%{#request.loginUser.account}" readonly="true"/>
        <s:textfield type="password" name="loginUser.password" label="修改密码" value="%{#request.loginUser.password}"/>
        <s:submit value="修改"/>
    </s:form>
    <s:form action="Userdelete" method="post"> <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
        <s:submit value="删除"/>
    </s:form>
</body>
</html>
