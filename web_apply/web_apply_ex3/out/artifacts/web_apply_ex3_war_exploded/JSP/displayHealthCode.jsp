<%@ page import="java.util.Date" %>
<%@ page import="java.util.SimpleTimeZone" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.File" %>
<%@ page import="com.google.zxing.common.BitMatrix" %>
<%@ page import="com.google.zxing.BarcodeFormat" %>
<%@ page import="com.google.zxing.MultiFormatWriter" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="bank.com.model.MatrixToImageWriter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/12
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="healthcode" class="bank.com.model.CheckformServlet" scope="session"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>健康码</title>
</head>
<body>
<div align="center">

    <h4>健康码</h4>
    <%
        request.setCharacterEncoding("UTF-8");
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat(" HH:mm:ss");
        String time = df.format(d);
        String time2 = df2.format(d);
//        String path = request.getContextPath();
        String path = request.getServletContext().getRealPath("/images/");
        String pathh = session.getServletContext().getRealPath("/images/")+"test.jpg";
        System.out.println(path);
        String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String name = request.getParameter("name");
//        File files = (File) request.getAttribute("file");
//        Map hint = new HashMap();
//        String id = (String) request.getAttribute("id");
//        String aa = "姓名"+name+"\n"+"学号(工号)"+id+"\n"+"生成时间"+time+time2;
//        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//        BitMatrix bitMatrix = multiFormatWriter.encode(aa, BarcodeFormat.QR_CODE,220,220,hint);
//        int choice = (int)request.getAttribute("choice");
//        MatrixToImageWriter.writeToFile(bitMatrix,"jpg",files,choice);
//        String title = "绿码:凭此码可在浙江省范围内通行，请主动出示，";
//        String title2 = "配合检查；并做好自身防护工作，码颜色将根据您的";
//        String title3 = "申报由当地政府按照相关政策动态更新，出行前请仔";
//        String title4 = "细检查您的健康码";

    %>
    <%=time%><br>
    <%=time2%><br>
    <%=name%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="JSP/inputInfo.jsp">修改信息</a><br>
    <img src="images/test.jpg"><br>

</div>
</body>
</html>
