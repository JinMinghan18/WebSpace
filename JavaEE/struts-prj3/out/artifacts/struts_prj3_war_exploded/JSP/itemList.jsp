<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <center>商品列表</center>
    <table border=1>
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>说明</th>
            <th>单价</th>
        </tr>
        <s:iterator value="items">
            <tr>
                <td><s:property value="itemID"/> </td>
                <td><s:property value="name"/> </td>
                <td><s:property value="description"/> </td>
                <td><s:property value="cost"/> </td>
            </tr>

        </s:iterator>
    </table>
</body>
</html>