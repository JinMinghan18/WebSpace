<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <sx:head/>
</head>
<body>
    <s:form action="register" method="POST">`
        <s:textfield name="loginUser.account" label="Account"/>
        <s:password name="loginUser.password" label="Password"/>
        <s:textfield name="loginUser.name" label="Name"/>
        <s:radio name="loginUser.sex" label="Sex" list="#{true:'男',false:'女'}"/>
        <sx:datetimepicker name="loginUser.birthday" displayFormat="yyyy-MM-dd" label="Birthday"/>
        <s:textfield name="loginUser.phone" label="Phone"/>
        <s:textfield name="loginUser.email" label="Email"/>
        <s:textfield name="loginUser.address" label="Address"/>
        <s:textfield name="loginUser.zipcode" label="Zipcode"/>
        <s:textfield name="loginUser.fax" label="Fax"/>
        <s:submit name="submit" label="submit"/>
        <s:reset name="reset" label="reset"/>
    </s:form>
</body>
</html>
