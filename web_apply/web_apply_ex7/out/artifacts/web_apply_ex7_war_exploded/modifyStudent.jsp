<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/30
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<font color="red">${result}</font>
<p>修改学生信息</p>
<form action="modifyStudent" method="post">
    <table>
        <tr><td>姓名：</td><td><input type="text" name="name" value="${student.name}"></td></tr>
        <tr><td>身份证号：</td><td><input type="text" name="id" value="${student.id}"></td></tr>
        <tr><td>学号：</td><td><input type="text" name="school_id" value="${student.school_id}"></td></tr>
        <tr><td>学院：</td><td><input type="text" name="college" value="${student.college}"></td></tr>
        <tr><td>专业：</td><td><input type="text" name="major" value="${student.major}"></td></tr>
        <tr><td>班级：</td><td><input type="text" name="class1" value="${student.class1}"></td></tr>
        <tr>
            <td><input type="submit" value="确定"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
