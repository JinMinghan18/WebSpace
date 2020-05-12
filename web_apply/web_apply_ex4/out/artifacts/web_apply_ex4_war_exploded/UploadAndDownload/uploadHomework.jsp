<%@ page import="com.demo.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/25
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业上交界面</title>
</head>
<body>
    <%
        UserBean userBean = (UserBean)session.getAttribute("userBean");
        if(userBean!=null){
    %>
    <form action="../upload" method="post" enctype="multipart/form-data">
        <table>
            <tr><td colspan="2" align="center">文件上传</td></tr>
            <tr>
                <td>作业标题:</td><td><input type="text" name="workNumber"></td>
            </tr>
            <tr>
                <td>文件名:</td><td><input type="file" name="fileName"></td>
            </tr>
            <tr><td><input type="submit" value="提交"></td><td><input type="reset" value="重置"></td></tr>
        </table>
    </form>
    <%}else{%>
    <%response.sendRedirect("../UploadAndDownload/login2.jsp");%>
    <%}%>

</body>
</html>
