<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/13
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理界面</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
</head>
<body>
<table class="table table-bordered" contenteditable="false">
    <thead>
    <tr>
        <td>姓名</td>
        <td>身份证号</td>
        <td>学号</td>
        <td>学院</td>
        <td>打卡</td>
        <td>健康码</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="school_info" items="${requestScope.teacher}"
               varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff">
        </c:if>
        <c:if test="${status.count%2!=0}">
            <tr style="background: #dedeff">
        </c:if>
        <td>${school_info.name}</td>
        <td>${school_info.id}</td>
        <td>${school_info.school_id}</td>
        <td>${school_info.college}</td>
        <td>${school_info.attendenceRecord}</td>
        <td>${school_info.healthcode}</td>
        <td>
            <a href="JSP/ModifyTeacherInfo.jsp?name=${school_info.name}&id=${school_info.id}&school_id=${school_info.school_id}&college=${school_info.college}&healthcode=${school_info.healthcode}">修改</a>
            <a href="TeacherDeleteServlet?name=${school_info.name}&id=${school_info.id}&school_id=${school_info.school_id}&college=${school_info.college}&healthcode=${school_info.healthcode}">删除</a>
        </td>
        </tr>
    </c:forEach>
    <tr>
        <td rowspan="9"><a href="JSP/AddTeacherInfo.jsp">添加</a></td>
    </tr>
    </tbody>
</table>

<p>
    <audio controls="controls" style="display: none;">&nbsp;</audio>
</p>

</body>
</html>
