<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/5
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>筛选结果</title>
</head>
<body>
    <table>
        <tr>
            <td colspan="6">筛选结果</td>
        </tr>
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>出版社</th>
            <th>出版时间</th>
            <th>ISBN</th>
            <th>价格</th>
        </tr>
        <c:forEach items="<%=request.getAttribute(\"selected\")%>" var="it">
            <tr>
                <jsp:useBean id="it" class="model.Book"></jsp:useBean>
                <td><jsp:getProperty property="title" name="it"/></td>
                <td><jsp:getProperty property="autuor" name="it"/></td>
                <td><jsp:getProperty property="publisher" name="it"/></td>
                <td><jsp:getProperty property="time" name="it"/></td>
                <td><jsp:getProperty property="ISBN" name="it"/></td>
                <td><jsp:getProperty property="price" name="it"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
