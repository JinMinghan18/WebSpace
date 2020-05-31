<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/28
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入一条客户记录</title>
</head>
<body>
    <font color="red">${result}</font>
    <form action="addCustomer.do" method="post">
        <table>
            <tr>
                <td>客户号：</td><td><input type="text" name="cust_id"></td>
            </tr>
            <tr>
                <td>客户名：</td><td><input type="text" name="cname"></td>
            </tr>
            <tr>
                <td>Email：</td><td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>余额：</td><td><input type="text" name="balance"></td>
            </tr>
            <tr><td><input type="submit" value="确定" ></td>
            <td><input type="reset" value="重置"></td></tr>
        </table>

    </form>
    <br><a href="allCustomer.do">查看所有客户信息</a>
</body>
</html>
