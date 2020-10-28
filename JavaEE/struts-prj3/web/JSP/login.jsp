<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/14
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        .text-left{
            text-align: right;
        }
    </style>
</head>
<body>

<s:i18n name="cn.edu.zjut.local.message">
    <s:fielderror/>
    <s:actionerror/>
    <s:form action="login" method="post">
        <s:property value="#session.tip"/>

        <s:textfield name="loginUser.account" key="login.account.label"/><br>
        <s:password name="loginUser.password" key="login.password.label"/>
        <s:submit name="submit" align="left" key="login.submit.button"/>
    </s:form>
</s:i18n>
</body>
</html>
