<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/16
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理界面</title>
</head>
<body>
<p><a href="test.jsp" >查询所有商品</a></p>
<form action="product-query" method="post">
    请输入商品号：
    <input type="text" name="productid" size="15">
    <input type="submit" value="确定">
</form>
</body>
</html>
