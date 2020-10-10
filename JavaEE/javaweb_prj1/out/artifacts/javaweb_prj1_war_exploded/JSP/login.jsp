<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/9
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
    <script type="text/javascript">
        function x() {
            var username = document.getElementsByName("username")[0].value;
            var password = document.getElementsByName("password")[0].value;
            if(username.length > 6){
                alert("用户名不能超过六位");
                return false;
            }
            else if(username == ""){
                alert("用户名不能为空");
                return false;
            }
            else if(password.length>6){
                alert("密码不能超过六位");
                return false;
            }else if(password == ""){
                alert("密码不能为空");
                return false;
            }
        }

    </script>
</head>
<%String path = request.getContextPath();%>
<body>

    <form action="<%=path%>/login" method="post" onsubmit="return x();">
        <table>
            <tr>
                <td>请输入用户名：</td>
                <td><input name="username" type="text"></td>
            </tr>
            <tr>
                <td>请输入密码:</td>
                <td><input name="password" type="password"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <select>
                        <option value="普通用户">普通用户</option>
                        <option value="管理员">管理员</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</body>
</html>
