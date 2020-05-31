<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/29
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示所有客户信息</title>
</head>
<body>
    ${result}
    <table border="1">
        <tr align="center">
            <td>客户编号</td>
            <td>姓名</td>
            <td>邮箱</td>
            <td>余额</td>
            <td>操作</td>
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
            <td>
                <a href="modifyCustomer.jsp?cust_id=${customer.cust_id}">修改</a>
                <a href="deleteCustomer.do?cust_id=${customer.cust_id}">删除</a>
            </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
