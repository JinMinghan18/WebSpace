<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/30
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息查询</title>
    <script type="text/javascript">
        function show1() {
            document.getElementById("1").style.display="block";
            document.getElementById("0").style.display="none";
        }
        function show2() {
            document.getElementById("1").style.display="none";
            document.getElementById("0").style.display="block";
        }
    </script>

</head>
<body>
<input type="button" name="a1" value="student" onclick="return show2();">
<input type="button" name="a1" value="teacher" onclick="return show1();">
<div id="0" style="display: none">
    <form action="queryStudent" method="post">
        <table>
            <tr>
                <td>学院:</td><td><input type="text" name="college"></td>
            </tr>
            <tr>
                <td>专业:</td><td><input type="text" name="major"></td>
            </tr>
            <tr>
                <td>班级:</td><td><input type="text" name="class1"></td>
            </tr>
            <tr>
                <td><input type="submit" value="查询"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</div>
<div id="1" style="display: block">
    <form action="queryTeacher" method="post">
        <table>
            <tr>
                <td>学院：</td><td><input type="text" name="college"></td>
            </tr>
            <tr>
                <td><input type="submit" value="查询"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</div>
    <p>
        <a href="allStudent">查询所有学生信息</a><br>
        <a href="allTeacher">查询所有教师信息</a><br>
        <a href="addStudent.jsp">新增学生信息</a><br>
        <a href="addTeacher.jsp">新增教师信息</a><br>
    </p>
</body>
</html>
