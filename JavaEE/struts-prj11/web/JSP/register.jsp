<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/15
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="GBK"/>
</head>
<body>
    <s:form action="register" method="POST">
        <s:textfield name="regUser.account" label="请输入用户名"/>
        <s:password name="regUser.password" label="请输入密码"/>
        <s:password name="regUser.repassword" label="请再次输入密码"/>
        <s:radio list="#{1:'男',0:'女'}" label="请输入性别" name="regUser.sex"/>
        <sx:datetimepicker name="regUser.birthday" displayFormat="yyyy-MM-dd" label="请输入生日" language="en"/>
        <s:submit value="注册"/>
        <s:reset value="重置"/>
    </s:form>
</body>
</html>
