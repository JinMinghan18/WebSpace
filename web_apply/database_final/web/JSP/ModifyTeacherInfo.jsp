<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/13
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息修改</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/CSS/HealthCodeLoginCSS.css">
    <script src="bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
</head>
<body style="background: #444444">
    <div class="modifytea">
        <div class="account">
            <div class="logo">教师信息修改界面</div>
            <form action="<%=path%>/modifyTeacherServlet" method="post">
                <div class="line">
                    <input class="inputtxt" value="<%=request.getParameter("tno")%>" name="tno" id="tno" placeholder="工号" type="text">
                </div>
                <div class="line" style="display: none">
                    <input class="inputtxt" value="<%=request.getParameter("tno")%>" name="tnoold" id="tnoold" placeholder="工号" type="text">
                </div>
                <div class="line">
                    <input class="inputtxt" value="<%=request.getParameter("tname")%>" name="tname" id="tname" placeholder="姓名" type="text">
                </div>
                <div class="line">
                    <input class="inputtxt" value="<%=request.getParameter("tsex")%>" name="tsex" id="tsex" placeholder="性别" type="text">
                </div>
                <div class="line">
                    <input class="inputtxt" value="<%=request.getParameter("tage")%>" name="tage" id="tage" placeholder="年龄" type="text">
                </div>
                <div class="line">
                    <input class="inputtxt" value="<%=request.getParameter("ttitle")%>" name="ttitle" id="ttitle" placeholder="职称" type="text">
                </div>
                <div class="line">
                    <input class="inputtxt" value="<%=request.getParameter("ttel")%>" name="ttel" id="ttel" placeholder="电话" type="text">
                </div>
                <div class="line">
                    <input class="inputtxt" value="" name="tpass" id="tpass" placeholder="密码" type="text">
                </div>
                <div class="login_btn">
                    <input id="" value="教师信息修改" type="submit">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
