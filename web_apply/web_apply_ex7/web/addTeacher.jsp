<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/30
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增教师信息</title>
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
<font color="red">${result}</font>
<input type="button" name="a1" value="输入一条" onclick="return show1();">
<input type="button" name="a1" value="批量导入" onclick="return show2();">
<div id="1" style="display: none">
    <form action="addTeacher">
        <table>
            <tr>
                <td>姓名：</td><td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>身份证号：</td><td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>工号：</td><td><input type="text" name="school_id"></td>
            </tr>
            <tr>
                <td>学院：</td><td><input type="text" name="college"></td>
            </tr>
            <tr>
                <td>身份：</td><td><input type="text" name="role"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</div>
<div id="0" style="display: block">
    <form action="addMoreTeacher" method="post">
        <p>请按name,id,school_id,college,role;格式依次输入，<br>逗号为间隔，分号为一条记录的结尾</p>
        <textarea rows="6" style="width: 435px;height: 120px;text-align: left;" name="added"></textarea><br>
        <input type="submit" value="批量导入">
    </form>
</div>
</body>
</html>
