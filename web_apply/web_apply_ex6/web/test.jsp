<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/17
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
    <%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webstore?serverTimezone=GMT%2B8","root","123456");
        Statement st = conn.createStatement();
        st.setMaxRows(20);
        String sqlStr = "select * from products";
        ResultSet rs = st.executeQuery(sqlStr);
    %>
    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>brand</td>
            <td>price</td>
            <td>stock</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <%while (rs.next()){%>
        <tr>
            <td><%=rs.getInt("id")%></td>
            <td><%=rs.getString("pname")%></td>
            <td><%=rs.getString("brand")%></td>
            <td><%=rs.getFloat("price")%></td>
            <td><%=rs.getInt("stock")%></td>
            <td><a href="modifyProduct.jsp?id=<%=rs.getInt("id")%>&pname=<%=rs.getString("pname")%>&brand=<%=rs.getString("brand")%>&price=<%=rs.getFloat("price")%>&stock=<%=rs.getInt("stock")%>">修改</a> </td>
            <td><a href="DeleteProduct?id=<%=rs.getInt("id")%>">删除</a></td>
        </tr>
        <%
            }
            rs.close();
            st.close();
            conn.close();
        %>
        <tr><td><a href="addProduct.jsp">添加</a></td></tr>
    </table>
</body>
</html>
