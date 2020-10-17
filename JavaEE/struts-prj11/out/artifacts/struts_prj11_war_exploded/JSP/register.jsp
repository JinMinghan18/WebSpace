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
    <s:i18n name="cn.edu.zjut.local.message">
        <s:form action="register" method="POST">
            <s:textfield name="regUser.account" key="register.account.label"/>
            <s:password name="regUser.password" key="register.password.label"/>
            <s:password name="regUser.repassword" key="register.repassword.label"/>
            <s:radio list="#{1:'男',0:'女'}" label="register.sex.label" name="regUser.sex"/>
            <sx:datetimepicker name="regUser.birthday" displayFormat="yyyy-MM-dd" key="register.birthday.label"/>
            <s:submit name="register.submit.button"/>
            <s:reset name="register.reset.buttton"/>
        </s:form>
    </s:i18n>
</body>
</html>
