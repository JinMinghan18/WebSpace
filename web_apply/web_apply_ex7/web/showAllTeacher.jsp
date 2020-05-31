<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/30
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有教师信息</title>
</head>
<body>
${result}
<table border="1">
    <tr align="center">
        <td>姓名</td>
        <td>身份证号</td>
        <td>工号</td>
        <td>学院</td>
        <td>身份</td>
        <td>操作</td>
    </tr>
    <c:forEach var="teacher" items="${requestScope.teacher}"
               varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff">
        </c:if>
        <c:if test="${status.count%2!=0}">
            <tr style="background: #dedeff">
        </c:if>
        <td>${teacher.name}</td>
        <td>${teacher.id}</td>
        <td>${teacher.school_id}</td>
        <td>${teacher.college}</td>
        <td>${teacher.role}</td>
        <td>
            <a href="modifyTeacher.jsp?name=${teacher.name}">修改</a>
            <a href="deleteTeacher?name=${teacher.name}">删除</a>
        </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
