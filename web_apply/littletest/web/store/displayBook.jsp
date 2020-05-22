<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/20
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="javaBean" class="com.book.JavaBeans" scope="session"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>书籍信息如下</h4>
<table>
    <tr>
        <td>书籍编号：</td>
        <td><jsp:getProperty name="javaBeans" property="bookId"/></td>
    </tr><br>
    <tr>
        <td>书籍标题：</td>
        <td><jsp:getProperty name="javaBeans" property="bookname"/></td>
    </tr><br>
    <tr>
        <td>作者：</td>
        <td><jsp:getProperty name="javaBeans" property="author"/></td>
    </tr>
</table>
</body>
</html>
