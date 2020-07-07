<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dao.HealthCodeDao" %>
<%@page import="com.model.Student" %>
<%@page import="com.model.Teacher" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/4
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%
    Date d1 = new Date();
    SimpleDateFormat dfd = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    String date = dfd.format(d1);
    double stu =(Double) request.getAttribute("studentAttendence");
    stu*=100;
%>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="referer" content="never" />
    <meta name="renderer" content="webkit">
    <title>学生管理</title>
    <link rel="shortcut icon" href="<%=path%>/static/image/favicon.ico" type="image/x-icon" />
    <link href="<%=path%>/static/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/site.css" rel="stylesheet" />
    <link href="<%=path%>/static/codemirror/lib/codemirror.css" rel="stylesheet" />
    <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
    <!--[if lte IE 9]>
    <script src="<%=path%>/static/js/requestAnimationFrame.js"></script>
    <![endif]-->
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
    <%
        HealthCodeDao dao = new HealthCodeDao();
        //饼图数据
        ArrayList<Integer> stuTea = dao.allstatistics();
        Integer fs=stuTea.get(0);
        Integer ufs=stuTea.get(1);
        Integer ft=stuTea.get(2);
        Integer uft=stuTea.get(3);
    %>
    <script language="JavaScript">
        var fs1="<%=fs%>"
        var ufs1="<%=ufs%>"
        var ft1="<%=ft%>"
        var uft1="<%=uft%>"
    </script>
</head>

<body>
<div class="bt-warp bge6">
    <div id="container" class="container-fluid">
        <div class="sidebar-scroll">
            <div class="sidebar-auto">
                <h3 class="mypcip"><span class="f14 cw">校级管理员</span></h3>
                <ul class="menu">


                    <li id="memuA"> <a class="menu_home" href="<%=path%>/JSP/SchoolAdministrators2.jsp">首页</a></li>



                    <li id="memuAsite"> <a class="menu_web" href="<%=path%>/StudentInfoCheckServlet">全校学生信息</a></li>


                    <li id="memuBsite"> <a class="menu_web" href="<%=path%>/TeacherInfoCheckServlet">全校老师信息</a></li>


                    <li id="memuCsite"> <a class="menu_web" href="<%=path%>/schoolInfoServlet">师生信息总览</a></li>

                </ul>
            </div>
        </div>
    </div>

    <div class="main-content pb55">
        <div class="container-fluid">
            <div class="pos-box bgw mtb15">
                <div class="position f14 c9 pull-left">
                    <a class="plr10 c4" href="<%=path%>/JSP/SchoolAdministrators2.jsp">首页</a>&gt&gt<span class="plr10 c4">学生管理</span>
                </div>
                <div class="search pull-right">
                    <form target="hid" onsubmit='database.get_list(1,$("#SearchValue").val())'>
                        <input type="text" id="SearchValue" class="ser-text pull-left" placeholder="搜索学生" />
                        <button type="button" class="ser-sub pull-left" onclick='database.get_list(1,$("#SearchValue").val())'></button>
                    </form>
                    <iframe name='hid' id="hid" style="display:none"></iframe>
                </div>
            </div>
            <div class="safe bgw mtb15 pd15">

                <div class="divtable mtb10">
                    <div class="tablescroll">
                        <h6>截至<%=date%></h6><br>
                        <h3>
                            学生打卡情况汇总
                        </h3>
                        <div id="main2" style="width: 900px;height:400px;margin:0 auto;text-align:center;"></div>
                        <script type="text/javascript">
                            //饼状图的方法
                            //对应放图片的Id（imageId）
                            //typeArr:对应名称的数组
                            //dataArr:对应名称数组的对应数据的数组
                            var dataArr = [fs1,ufs1];
                            var typeArr = new Array("打卡学生","未打卡学生");
                            var ListFirstArr = new Array();
                            for (var i = 0; i < typeArr.length; i++) {
                                var item = {
                                    value: dataArr[i],
                                    name: typeArr[i]
                                };
                                ListFirstArr.push(item);
                            }
                            // 基于准备好的dom，初始化echarts图表
                            var myChart = echarts.init(document.getElementById('main2'));
                            option = {
                                title: {
                                    text: '',
                                    subtext: '',
                                    x: 'center'
                                },
                                tooltip: {
                                    trigger: 'item',
                                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                                },
                                legend: {
                                    orient: 'vertical',
                                    left: 'left',
                                    data: typeArr
                                },
                                series: [
                                    {
                                        name: '今日数据',
                                        type: 'pie',
                                        radius: '55%',
                                        center: ['50%', '60%'],
                                        data: ListFirstArr,
                                        itemStyle: {
                                            emphasis: {
                                                shadowBlur: 10,
                                                shadowOffsetX: 0,
                                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                                            }
                                        }
                                    }
                                ]
                            };
                            myChart.setOption(option);
                        </script>
                        <h4>学生打卡率：<%=stu%>%</h4>
                        <table id="DataBody" class="table table-hover" width="100%" cellspacing="0" cellpadding="0" border="0" style="border: 0 none;">
                            <thead>
                            <tr>
                                <th>姓名</th>
                                <th>身份证号</th>
                                <th>学号</th>
                                <th>学院</th>
                                <th>专业</th>
                                <th>班级</th>
                                <th>打卡情况</th>
                                <th>健康码</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="student" items="${requestScope.student}"
                                       varStatus="status">
                                <c:if test="${status.count%2==0}">
                                    <tr style="background: #eeeeff">
                                </c:if>
                                <c:if test="${status.count%2!=0}">
                                    <tr style="background: #dedeff">
                                </c:if>
                                <td>${student.name}</td>
                                <td>${student.id}</td>
                                <td>${student.school_id}</td>
                                <td>${student.college}</td>
                                <td>${student.major}</td>
                                <td>${student.class1}</td>
                                <td>${student.attendenceRecord}</td>
                                <td>${student.healthcode}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="footer bgw">版权所有 © 浙江工业大学 | 信息化办公室维护 | 网络管理 www@zjut.edu.cn</div>
</div>
</body>
</html>