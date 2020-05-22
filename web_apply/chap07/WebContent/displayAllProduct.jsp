<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>显示所有商品</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>商品号</td>
			<td>商品名</td>
			<td>价格</td>
			<td>数量</td>
		</tr>
		<c:forEach var="product" items="${sessionScope.productList}"
			varStatus="status">
			<%--为奇数行和偶数行设置不同的背景颜色--%>
			<c:if test="${status.count%2==0}">
				<tr style="background: #eeeeff">
			</c:if>
			<c:if test="${status.count%2!=0}">
				<tr style="background: #dedeff">
			</c:if>
			<%--用EL访问作用域变量的成员--%>
			<td>${product.prod_id}</td>
			<td>${product.pname}</td>
			<td>${product.price}</td>
			<td>${product.stock}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
