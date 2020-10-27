<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/14
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:i18n name="cn.edu.zjut.local.message">
    <s:actionmessage name="login" key="login.success.label"/>,<s:text name="login.successtext1.text"/><s:property value="getCount()"/><s:text name="login.successtext2.text"/>
</s:i18n>

</body>
</html>
