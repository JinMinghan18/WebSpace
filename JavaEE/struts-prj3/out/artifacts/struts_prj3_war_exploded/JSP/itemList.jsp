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
    <title>��Ʒ�б�</title>
</head>
<body>
    <%
        ValueStack vs = (ValueStack)request.getAttribute("struts.valueStack");
        String title = vs.findString("tableTitle");
        List itemList = (List)vs.findValue("items");
    %>
    <s:property value="#session.user"/>,����
    <center>��Ʒ�б�</center>
    <table border=1>
        <tr>
            <th>���</th>
            <th>����</th>
            <th>˵��</th>
            <th>����</th>
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
    �۸����20Ԫ����Ʒ�У�<br>
    <s:iterator value="items.{?#this.cost<20}">
        <li>
            <s:property value="name"/>:
            <s:property value="cost"/>Ԫ
        </li>
    </s:iterator>
    ����Ϊ��JAVAEE����ʵ��ָ���̡̳�����Ʒ�ļ۸�Ϊ��
    <s:property value="items.{?#this.name =='JAVAEE����ʵ��ָ���̳�'}.{cost}[0]"/>Ԫ<br>

    <s:url value="items.{name}[0]"/><br>
    <s:url value="%{items.{name}[0]}"/>
</body>
</html>
