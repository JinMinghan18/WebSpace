<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/20
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action= computeAvgScorePoint.do" method="post">
<fieldset>
    <legend>成绩提交</legend>
    <p>
        <label>web应用开发<input type="text" name="a"/></label>
    </p>
    <p>
        <label>计算机网络<input type="text" name="b"/></label>
    </p>
    <p>
        <label>数据库<input type="text" name="c"/></label>
    </p>
    <p>
        <label><input type="submit" value="成绩提交"/></label>
    </p>
</fieldset>
</form>
</body>
</html>
