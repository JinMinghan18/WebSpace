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
        <form action="login" method="post">
            <s:textfield name="loginUser.account" label="请输入账号" key="login.account.label"/><br>
            <s:password name="loginUser.password" label="请输入密码" key="login.password.label"/>
            <s:submit name="submit" key="login.submit.button" label="提交" align="left"/>
        </form>
    </s:i18n>
</body>
</html>
