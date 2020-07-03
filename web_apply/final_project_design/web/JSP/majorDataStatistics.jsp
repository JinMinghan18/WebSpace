<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>

<%
    Date d1 = new Date();
    SimpleDateFormat dfd = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    String date = dfd.format(d1);
    String college= (String) request.getAttribute("college");
    Integer fs= (Integer) request.getAttribute("fs");
    Integer ufs= (Integer) request.getAttribute("ufs");
    Integer ft= (Integer) request.getAttribute("ft");
    Integer uft= (Integer) request.getAttribute("uft");
%>
<script language="JavaScript">
    var fs1="<%=fs%>"
    var ufs1="<%=ufs%>"
    var ft1="<%=ft%>"
    var uft1="<%=uft%>"
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>院级师生打卡统计</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h1 class="text-center">
                <%=college%> 学院师生打卡情况汇总
            </h1>
            <h6>截至<%=date%></h6><br>
            <%--饼图--%>
            <div id="main" style="width: 900px;height:400px;margin:0 auto;text-align:center;"></div>
            <script type="text/javascript">
                //饼状图的方法
                //对应放图片的Id（imageId）
                //typeArr:对应名称的数组
                //dataArr:对应名称数组的对应数据的数组
                var dataArr = [fs1,ufs1,ft1,uft1];
                var typeArr = new Array("打卡学生","未打卡学生","打卡教师","未打卡教师");
                var ListFirstArr = new Array();
                for (var i = 0; i < typeArr.length; i++) {
                    var item = {
                        value: dataArr[i],
                        name: typeArr[i]
                    };
                    ListFirstArr.push(item);
                }
                // 基于准备好的dom，初始化echarts图表
                var myChart = echarts.init(document.getElementById('main'));
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
            <%--统计未打卡情况表--%>
            <h3>
                教师未打卡情况
            </h3>
            <h4>教师打卡率：<%=request.getAttribute("teacherAttendence")%></h4>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>身份证号</th>
                    <th>学号</th>
                    <th>学院</th>
                    <th>职务</th>
                    <th>打卡情况</th>
                    <th>健康码</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="teacher" items="${requestScope.teacher}"
                           varStatus="status">
                    <c:if test="${status.count%2==0}">
                        <tr style="background: #eeeeff">
                    </c:if>
                    <c:if test="${status.count%2!=0}">
                        <tr style="background: #dedeff">
                    </c:if>
                    <td>${teacher.name}</td>
                    <td>${teacher.id}</td>
                    <td>${teacher.school_id}</td>
                    <td>${teacher.college}</td>
                    <td>${teacher.role}</td>
                    <td>${teacher.attendenceRecord}</td>
                    <td>${teacher.healthcode}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <h3>
                学生未打卡情况
            </h3>
            <h4>学生打卡率：<%=request.getAttribute("studentAttendence")%></h4>
            <table class="table">
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
                <c:forEach var="teacher" items="${requestScope.student}"
                           varStatus="status">
                    <c:if test="${status.count%2==0}">
                        <tr style="background: #eeeeff">
                    </c:if>
                    <c:if test="${status.count%2!=0}">
                        <tr style="background: #dedeff">
                    </c:if>
                    <td>${teacher.name}</td>
                    <td>${teacher.id}</td>
                    <td>${teacher.school_id}</td>
                    <td>${teacher.college}</td>
                    <td>${teacher.major}</td>
                    <td>${teacher.class1}</td>
                    <td>${teacher.attendenceRecord}</td>
                    <td>${teacher.healthcode}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>