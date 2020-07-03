<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/3
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%String path1 = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示二维码</title>
    <link rel="stylesheet" href="<%=path1%>/CSS/HealthCodeLoginCSS.css">
</head>
<body style="background: #444444">
<div class="login2">
    <div class="account">
        <%
            request.setCharacterEncoding("UTF-8");
            Date d = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat(" HH:mm:ss");
            String time = df.format(d);
            String time2 = df2.format(d);
            String path = request.getServletContext().getRealPath("/images/");
            String pathh = session.getServletContext().getRealPath("/images/")+"test.jpg";
            System.out.println(path);
            String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            String name = request.getParameter("name");
        %><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%=name%>你好<br>
        <div style="text-align: center">
             请在接受检查时主动出示工大健康码，<br>配合管理员的工作，做好自生防护工作，<br>你的健康码状态将根据你的申报动态刷新
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/test.jpg"><br>

    </div>
</div>
</body>
</html>
