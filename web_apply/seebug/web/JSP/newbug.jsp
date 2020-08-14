<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/4
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    seebugdao dao = new seebugdao();
    ArrayList<newbug> newbugArrayList = dao.allnewbugInfo();
    request.setAttribute("newbugArrayList",newbugArrayList);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="referer" content="never" />
    <meta name="renderer" content="webkit">
    <title>SEEBUG</title>
    <link rel="shortcut icon" href="<%=path%>/static/image/favicon.ico" type="image/x-icon" />
    <link href="<%=path%>/static/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/site.css" rel="stylesheet" />
    <link href="<%=path%>/static/codemirror/lib/codemirror.css" rel="stylesheet" />
    <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>

    <style>
        .top-tips {
            height: 50px;
            width: 100%;
            color: red;
            position: fixed;
            top: 0;
            z-index: 999;
            background-color: white;
            text-align: center;
            line-height: 50px;
            font-size: 20px;
            border-bottom: 1px solid #f0f0f0;
            font-weight: bold;
            display: none;
        }
        .contextmenu {
            position: absolute;
            width: 120px;
            background: #FFFFFF;
            border-radius: 5px;
            overflow: hidden;
            z-index: 99999999;
        }
        .contextmenu li {
            border-left: 3px solid transparent;
            transition: ease 0.3s;
        }
        .contextmenu li:hover {
            background: #707070;
            border-left: 3px solid #333;
        }
        .contextmenu li a {
            display: block;
            padding: 5px 10px;
            color: #000000;
            text-decoration: none;
            transition: ease 0.3s;
            cursor:default;
        }
        .contextmenu li:hover a {
            color: #fff;
        }
    </style>
</head>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.newbug" %>
<%@ page import="com.dao.seebugdao" %>
<%@ page import="static sun.misc.Version.print" %>


<script language="JavaScript">
</script>
<body>
<div class="bt-warp bge6">
    <div id="container" class="container-fluid">
        <div class="sidebar-scroll">
            <div class="sidebar-auto">
                <h3 class="mypcip"><span class="f14 cw">seebug_display</span></h3>
                <ul class="menu">


                    <li id="memuA"> <a class="menu_home" href="<%=path%>/selectAllNewbugServlet">newbug</a></li>



                    <li id="memuAsite"> <a class="menu_web" href="<%=path%>/selectAllNewpaperServlet">newpaper</a></li>


                    <li id="memuBsite"> <a class="menu_web" href="<%=path%>/selectAllNewPOCServlet">newPOC</a></li>


                </ul>
            </div>
        </div>
    </div>
    <div class="main-content">
        <div class="container-fluid" style="padding-bottom: 66px;">
            <div class="server bgw mtb15">
                <div class="title c6 f16 plr15">
                    <h3 class="c6 f16 pull-left">newbug</h3>
                </div>
                <div class="server-circle">
                    <table id="firewallBody" class="table table-hover" style="min-width: 640px;border: 0 none;">
                        <thead>
                            <tr>
                                <th style="width: 10%">SSV_ID</th>
                                <th>update_time</th>
                                <th>bug_name</th>
                                <th>bug_level</th>
                                <th>bug_status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i_item" items="${requestScope.newbugArrayList}" varStatus="status">
                                <c:if test="${status.count%2==0}">
                                    <tr style="background: #eeeeff">
                                </c:if>
                                <c:if test="${status.count%2!=0}">
                                    <tr style="background: #dedeff">
                                </c:if>
                                <td>${i_item.SSV_ID}</td>
                                <td>${i_item.update_time}</td>
                                <td>${i_item.bug_name}</td>
                                <td>${i_item.bug_level}</td>
                                <td>${i_item.bug_status}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            </div>
        </div>

    </div>
<%--    <div class="footer bgw">版权所有 © 浙江工业大学 | 信息化办公室维护 | 网络管理 www@zjut.edu.cn</div>--%>
</div>

</body>
</html>
