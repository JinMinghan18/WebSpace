<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int count = 0;%>
<%!
    String color[] = {"red","green","blue"};
    String getColor(int i){
        return color[i];
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  count++;
%>
该页面已被访问<%=count%>次。

<%
    out.print("<html><body>");
    count++;
    out.println(" sss ");
    out.print("该页面已经被访问"+count+"次");
    out.print("</body></html>");
%>
</body>
</html>
