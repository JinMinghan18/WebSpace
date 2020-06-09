<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/9
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生教师登录界面</title>
    <script type="text/javascript">
        function check_form() {
            var name = document.getElementById("name");
            var school_id = document.getElementById("school_id");
            var id = document.getElementById("id");
            if(name.value==""){
                alert("姓名为空");
                return false;
            }
            else if(school_id.value==""){
                alert("学号为空");
                return false;
            }
            else if(id.value==""){
                alert("身份证号后八位为空");
                return false;
            }
        }
    </script>
</head>
<body style="background: #999">
<form action="login.do" method="post" onsubmit="return check_form();">
    <table align="center" style="border:1px solid #0aa8ff;">
        <tbody>
        <tr><td colspan="2"><h3 style="color: #0aa8ff;text-align: center">师生打卡登录</h3></td></tr>
        <tr><td>姓 &nbsp;名:</td><td><input type="text" placeholder="请输入用户名" id="name" name="name"></td></tr>
        <tr><td>学 &nbsp;号:</td><td><input type="text" id="school_id" placeholder="请输入密码" name="school_id"></td></tr>
        <tr><td>身份证:</td><td><input type="text" name="id" id="id" placeholder="请输入身份证号码后八位"></td></tr>
        <tr><td colspan="2" style="text-align: center"><input type="submit" style="background-color: #0aa8ff;width: 95%;"></td></tr>
        </tbody>
    </table>
</form>
</body>
</html>
