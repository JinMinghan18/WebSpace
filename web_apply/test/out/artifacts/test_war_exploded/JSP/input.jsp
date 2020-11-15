<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/13
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>input</title>
</head>
<body>
<form action="../Check_Servlet.do" method="post">
    <fieldset>
        <legend>三角形面积计算</legend>
        <p>
            <label>边长1:<input type="number" name="side_length_1" /></label><br/>
            <label>边长2:<input type="number" name="side_length_2" /></label><br/>
            <label>边长3:<input type="number" name="side_length_3" /></label><br/>
            <input type="submit" value="计算">
        </p>
    </fieldset>
</form>

</body>
</html>
