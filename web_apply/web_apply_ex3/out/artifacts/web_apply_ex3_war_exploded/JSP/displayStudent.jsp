<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="stu.Student" scope="session"/>
<html>
<head>
    <title>显示学生信息</title>
</head>
<body>
    <h4>学生信息如下</h4>
    <table>
        <tr>
            <td>学号：</td>
            <td><jsp:getProperty name="student" property="stuId"/></td>
        </tr><br>
        <tr>
            <td>姓名：</td>
            <td><jsp:getProperty name="student" property="name"/></td>
        </tr><br>
        <tr>
            <td>专业：</td>
            <td><jsp:getProperty name="student" property="major"/></td>
        </tr>
    </table>
</body>
</html>
