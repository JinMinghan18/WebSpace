<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/20
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="../BookServlet" method="post">

    <table>
        <tr><td>书籍编号：</td><td><input type="text" name="bookId" /> </td></tr>
        <tr><td>书籍名称：</td><td><input type="text" name="bookname" /> </td></tr>
        <tr><td>作者：</td><td><input type="text" name="author" /> </td></tr>
        <tr><td><input type="submit" value="确定"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>

</form>
</body>
</html>
