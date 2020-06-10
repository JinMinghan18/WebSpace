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
    <link rel="stylesheet" type="text/css" href="../CSS/HealthCodeLoginCSS.css">
</head>
<body style="background: #444444">

    <div class="login">
        <div class="account">
            <form action="login.do" method="post" onsubmit="return check_form();">
                <div class="logo">师生登录界面</div>
                <div class="line">
                    <input class="inputtxt" value name="name" datatype="*"
                           nullmsg="请填写账号" placeholder="姓名" type="text">
                </div>
                <div class="line">
                    <input class="inputtxt" name="school_id" type="text" placeholder="学号"
                           nullmsg="请输入学号" datatype="*">
                </div>
                <div class="line">
                    <input class="inputtxt" name="id" type="text" placeholder="身份证后八位"
                           nullmsg="请输入身份证" datatype="*">
                </div>
                <div class="login_btn">
                    <input id="login-button" value="登录" type="submit">
                </div>
            </form>
        </div>
    </div>
<%--        <tbody>--%>
<%--        <tr><td colspan="2"><h3 style="color: #0aa8ff;text-align: center">师生打卡登录</h3></td></tr>--%>
<%--        <tr><td>姓 &nbsp;名:</td><td><input type="text" placeholder="请输入用户名" id="name" name="name"></td></tr>--%>
<%--        <tr><td>学 &nbsp;号:</td><td><input type="text" id="school_id" placeholder="请输入密码" name="school_id"></td></tr>--%>
<%--        <tr><td>身份证:</td><td><input type="text" name="id" id="id" placeholder="请输入身份证号码后八位"></td></tr>--%>
<%--        <tr><td colspan="2" style="text-align: center"><input type="submit" style="background-color: #0aa8ff;width: 95%;"></td></tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>

</body>
</html>
