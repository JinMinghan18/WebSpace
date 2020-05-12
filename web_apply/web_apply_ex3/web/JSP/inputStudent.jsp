<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入学生信息</title>
</head>
<body>
<div align="center">
    <h4>输入学生信息</h4>
    <form action="../StudentServlet" method="post">

        <table>
            <tr><td>学号：</td><td><input type="text" name="stuId" /> </td></tr>
            <tr><td>姓名：</td><td><input type="text" name="name" /> </td></tr>
            <tr><td>专业：</td><td><input type="text" name="major" /> </td></tr>
            <tr><td><input type="submit" value="确定"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
