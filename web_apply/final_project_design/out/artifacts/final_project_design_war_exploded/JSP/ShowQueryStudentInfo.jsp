<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/12
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生查询结果</title>
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
            <td>打卡</td>
            <td>健康码</td>
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
            <td>${student.attendenceRecord}</td>
            <td>${student.healthcode}</td>
            <td>
                <a href="#">修改</a>
                <a href="#">删除</a>
            </td>
            </tr>
        </c:forEach>
        <tr>
            <td rowspan="9"><a href="#">添加</a></td>
        </tr>
    </table>

</body>
</html>
