<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:property value="loginUser.account"/>
<s:if test="%{loginUser.sex == \"1\"}">
    <s:text name="先生，"/>
</s:if>
<s:else>
    <s:text name="女士，"/>
</s:else>
您注册成功了
<s:property value="#request.tip"/>
</body>
</html>
