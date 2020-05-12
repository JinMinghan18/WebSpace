<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/5
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="demo" uri="http://www.Mathtag.com/sample" %>
<html>
<head>
    <title>result</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletContext().getRealPath("/WEB-INF/search.txt");
    %>
    <demo:mark search='<%=request.getParameter("key")%>' path='<%=path%>'/>
</body>
</html>
