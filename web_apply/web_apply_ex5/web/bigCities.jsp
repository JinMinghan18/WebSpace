<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/5
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>首都-城市</title>
</head>
<body>
    <table>
        <tr style="background-color: greenyellow; color: white">
            <th>国家</th>
            <th>首都</th>
        </tr>
        <c:forEach items="<%=request.getAttribute(\"capitals\")%>" var="its">
            <tr>
                <td>${its.getKey()}</td>
                <td>${its.getValue()}</td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr style="color: white; background-color: greenyellow">
            <th>国家</th>
            <th>城市</th>
        </tr>
        <c:forEach items="<%=request.getAttribute(\"bigCities\")%>" var="its">
            <tr>
                <td>${its.getKey()}</td>
                <td>
                        <c:forEach items="${its.getValue()}" var="city">
                        ${city},
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
