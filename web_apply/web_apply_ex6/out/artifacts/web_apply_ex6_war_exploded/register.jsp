<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/17
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript">
        function show1() {
            document.getElementById("1").style.display="block";
            document.getElementById("0").style.display="none";
        }
        function show2() {
            document.getElementById("0").style.display="block";
            document.getElementById("1").style.display="none";
        }
    </script>
</head>
<body>
<input type="button" name="a1" value="student" onclick="return show1();">
<input type="button" name="a1" value="teacher" onclick="return show2();">
<div id="0" style="display: none">
    <form action="RegisterTeacher" method="post">
        <table>
            <tr><td>姓名：</td><td><input type="text" name="name" value=""></td></tr>
            <tr><td>身份证：</td><td><input type="text" name="idnumber" value=""></td></tr>
            <tr><td>工号：</td><td><input type="text" name="number" value=""></td></tr>
            <tr><td>密码：</td><td><input type="password" name="password" value=""></td></tr>
            <tr><td>学院：</td><td><input type="text" name="college" value=""></td></tr>
            <tr>
                <td>
                    <select name="role">
                        <option value="systema">系统管理员</option>
                        <option value="schoola">校级管理员</option>
                        <option value="collegea">院级管理员</option>
                        <option value="teachera">普通教师</option>
                    </select>
                </td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="注册" /></td></tr>
        </table>

    </form>
</div>
<div id="1" style="display: block">
    <form action="RegisterStudent" method="post">
        <table>
            <tr><td>姓名：</td><td><input type="text" name="name" value=""></td></tr>
            <tr><td>身份证：</td><td><input type="text" name="idnumber" value=""></td></tr>
            <tr><td>学号：</td><td><input type="text" name="number" value=""></td></tr>
            <tr><td>密码：</td><td><input type="password" name="password" value=""></td></tr>
            <tr><td>学院：</td><td><input type="text" name="college" value=""></td></tr>
            <tr><td>专业：</td><td><input type="text" name="major" value=""></td></tr>
            <tr><td>班级：</td><td><input type="text" name="class1" value=""></td></tr>
            <tr><td colspan="2"><input type="submit" value="注册"></td> </tr>
        </table>
    </form>
</div>
</body>
</html>
