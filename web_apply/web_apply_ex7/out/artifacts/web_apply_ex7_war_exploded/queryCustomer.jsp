<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/29
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户查询</title>
</head>
<body>
    <form action="queryCustomer.do" method="post">
        请输入客户姓名：<input type="text" name="cname" size="15">
        <input type="submit" value="确定">
    </form>
    <p>
        <a href="allCustomer.do">查询所有客户</a>
    </p>
</body>
</html>
