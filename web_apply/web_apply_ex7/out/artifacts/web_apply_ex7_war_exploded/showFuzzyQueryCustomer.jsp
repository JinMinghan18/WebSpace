<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/29
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示迷糊查询的客户信息</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>客户编号</td>
            <td>姓名</td>
            <td>邮箱</td>
            <td>余款</td>
        </tr>
        <c:forEach var="customer" items="${requestScope.customer}"
                   varStatus="status">
            <%--为奇数行和偶数行设置不同背景色--%>
            <c:if test="${status.count%2==0}">
                <tr style="background: #eeeeff">
            </c:if>
            <c:if test="${status.count%2!=0}">
                <tr style="background: #dedeff">
            </c:if>
            <%--用EL访问作用域的成员--%>
            <td>${customer.cust_id}</td>
            <td>${customer.cname}</td>
            <td>${customer.email}</td>
            <td>${customer.balance}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
