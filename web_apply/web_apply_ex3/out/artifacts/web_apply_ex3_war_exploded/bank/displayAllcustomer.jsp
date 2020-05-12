<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.BufferedReader" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有注册用户信息</title>
</head>
<body>
<%
    FileReader fr = new FileReader("D:\\MyStudySpace\\WebSpace\\web_apply\\web_apply_ex3\\userInfo.txt");
    BufferedReader br = new BufferedReader(fr);
    StringBuffer strb = new StringBuffer();
    String str = br.readLine();
    while(str!=null){
        int pos1,pos2;
        pos1 = str.indexOf("|");
        pos2 = str.indexOf("|",str.indexOf("|")+1);
        String str1 = str.substring(0,pos1);
        String str2 = str.substring(pos2);
        strb = strb.append(str1+str2).append("<br>");
        str = br.readLine();
    }
    br.close();
%>
邮箱|账户|电话<br>
<table>
    <%=strb%>
</table>
</body>
</html>
