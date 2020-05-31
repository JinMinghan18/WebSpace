<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/31
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询学生</title>
</head>
<body>
<table border="1">
    <tr align="center">
        <td>姓名</td>
        <td>身份证号</td>
        <td>学号</td>
        <td>学院</td>
        <td>专业</td>
        <td>班级</td>
        <td>操作</td>
    </tr>
    <c:forEach var="student" items="${requestScope.student}"
               varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff">
        </c:if>
        <c:if test="${status.count%2!=0}">
            <tr style="background: #dedeff">
        </c:if>
        <td>${student.name}</td>
        <td>${student.id}</td>
        <td>${student.school_id}</td>
        <td>${student.college}</td>
        <td>${student.major}</td>
        <td>${student.class1}</td>
        <td>
            <a href="modifyStudent.jsp?name=${student.name}">修改</a>
            <a href="deleteStudent?name=${student.name}">删除</a>
        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
