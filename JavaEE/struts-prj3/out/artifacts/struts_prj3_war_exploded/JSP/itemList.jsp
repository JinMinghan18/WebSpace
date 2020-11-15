<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB18030" language="java" pageEncoding="GB18030"
import="com.opensymphony.xwork2.util.ValueStack,
        java.util.List,java.util.Iterator,
        cn.edu.zjut.bean.Item"
%>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <%
        ValueStack vs = (ValueStack)request.getAttribute("struts.valueStack");
        String title = vs.findString("tableTitle");
        List itemList = (List)vs.findValue("items");
    %>
    <s:property value="#session.user"/>,您好
    <center>商品列表</center>
    <table border=1>
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>说明</th>
            <th>单价</th>
        </tr>
<%--        <% Iterator it = itemList.iterator();--%>
<%--            while (it.hasNext()){--%>
<%--                Item item = (Item)it.next();--%>

<%--        %>--%>
<%--            <tr>--%>
<%--                <td><%=item.getItemID()%> </td>--%>
<%--                <td><%=item.getName()%> </td>--%>
<%--                <td><%=item.getDescription()%> </td>--%>
<%--                <td><%=item.getCost()%> </td>--%>
<%--            </tr>--%>

<%--        <%--%>
<%--            }--%>
<%--        %>--%>
        <s:iterator value="items">
            <tr>
                <td><s:property value="itemID"/> </td>
                <td><s:property value="name"/> </td>
                <td><s:property value="description"/> </td>
                <td><s:property value="cost"/> </td>
            </tr>
        </s:iterator>


    </table>
    价格低于20元的商品有：<br>
    <s:iterator value="items.{?#this.cost<20}">
        <li>
            <s:property value="name"/>:
            <s:property value="cost"/>元
        </li>
    </s:iterator>
    名称为《JAVAEE技术实验指导教程》的商品的价格为：
    <s:property value="items.{?#this.name =='JAVAEE技术实验指导教程'}.{cost}[0]"/>元<br>

    <s:url value="items.{name}[0]"/><br>
    <s:url value="%{items.{name}[0]}"/>
</body>
</html>
