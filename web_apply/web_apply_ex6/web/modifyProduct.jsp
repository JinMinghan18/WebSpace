<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/17
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pname = request.getParameter("pname");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
    %>
    <form action="updateProduct" method="post">
        请输入修改后的数据：<br>
        商品号：<input type="text" name="id" value="<%=id%>" onfocus="this.blur()" /><br>
        商品名：<input type="text" name="pname" value="<%=pname%>" /><br>
        品牌：<input type="text" name="brand" value="<%=brand%>" /><br>
        价格：<input type="text" name="price" value="<%=price%>" /><br>
        库存：<input type="text" name="stock" value="<%=stock%>" /><br>
        <input type="submit" value="修改" />
    </form>
</body>
</html>
