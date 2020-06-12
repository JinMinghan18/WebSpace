<%@ page contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	Class.forName("org.postgresql.Driver");
	Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");
	Statement st = conn.createStatement();
	st.setMaxRows(20);
	String sqlStr = "select * from products";
	ResultSet rs = st.executeQuery(sqlStr);
%>
<table border=1>
<tr><td>商品编号</td><td>商品名称</td><td>价格</td><td>库存量</td></tr>
<%
	while (rs.next()) {
%>
<tr>
<td><%=rs.getString("prod_id")%></td>
<td><%=rs.getString("pname")%></td>
<td><%=rs.getDouble("price")%></td>
<td><%=rs.getString("stock")%></td>
</tr>
<%
	}
	rs.close();
	st.close();
	conn.close();
%>
</table>