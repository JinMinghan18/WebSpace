<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/15
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>说明</th>
            <th>单价</th>
            <th>图片</th>
        </tr>
        <s:iterator value="items">
            <tr>
<%--                <td><s:property value="isbn"/> </td>--%>
<%--                <td><s:property value="title"/> </td>--%>
                <td><s:property value="ipk.isbn"/> </td>
                <td><s:property value="description"/> </td>
                <td><s:property value="cost"/> </td>
                <td><s:property value="image"/> </td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
