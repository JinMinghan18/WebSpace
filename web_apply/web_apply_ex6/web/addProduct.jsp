<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/17
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
    <form action="AddProduct" method="post">
        添加商品:<br>
        商品名
        <input type="text" name="pname" size="15"><br>
        品牌
        <input type="text" name="brand" size="15"><br>
        价格
        <input type="text" name="price" size="15"><br>
        库存
        <input type="text" name="stock" size="15"><br>
        <input type="submit" value="确定" name="add">
    </form>
</body>
</html>
