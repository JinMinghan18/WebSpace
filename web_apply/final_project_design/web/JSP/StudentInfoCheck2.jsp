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
    <div class="top-tips">当前IE浏览器版本过低,部分功能无法展示,请更换至其他浏览器，国产浏览器请使用极速模式！</div>
    <a style="display:none;" id="request_token_head" token="WtPUOJGA91Q4CCSxoUAf8tkz2BVpshzb0jXxtJHgnwC1h5LE"></a>
    <div id="container" class="container-fluid">
        <div class="sidebar-scroll">
            <div class="sidebar-auto">
                <h3 class="mypcip"><span class="f14 cw">学生管理系统</span></h3>
                <ul class="menu">


                    <li id="memuA"> <a class="menu_home" href="JSP/SchoolAdministrators2.jsp">首页</a></li>



                    <li id="memuAsite"> <a class="menu_web" href="StudentInfoCheckServlet">全校学生信息</a></li>


                    <li id="memuBsite"> <a class="menu_web" href="TeacherInfoCheckServlet">全校老师信息</a></li>


                    <li id="memuCsite"> <a class="menu_web" href="#">师生信息总览</a></li>

                </ul>
                <div id="newbtpc"></div>
                <div class="btpc-plus" onclick="bindBTPanel(0,'b')">+</div>
            </div>
        </div>
        <button style="display: none;" id="bt_copys" class="bt_copy" data-clipboard-text=""></button>
        <a style="display: none;" id="defaultPath">/www/wwwroot</a>
    </div>

    <div class="main-content pb55">
        <div class="container-fluid">
            <div class="pos-box bgw mtb15">
                <div class="position f14 c9 pull-left">
                    <a class="plr10 c4" href="index.html">首页</a>&gt&gt<span class="plr10 c4">学生管理</span>
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
                        <h4>学生打卡率：<%=request.getAttribute("studentAttendence")%></h4>
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
                    <div id='databasePage' class="dataTables_paginate paging_bootstrap page">
                    </div>
                </div>
            </div>
            <form id="toPHPMyAdmin" action="http://39.97.238.64:888/phpmyadmin_9d6bd9ac44b8d96f/index.php" method="post" style="display: none;" target="_blank">
                <input type="text" name="pma_username" id="pma_username" value="" />
                <input type="password" name="pma_password" id="pma_password" value="" />
                <input type="text" name="server" value="1" />
                <input type="text" name="target" value="index.php" />
                <input type="text" name="db" id="db" value="" />
            </form>
        </div>
    </div>


    <div class="footer bgw">版权所有 © 浙江工业大学 | 信息化办公室维护 | 网络管理 www@zjut.edu.cn</div>
</div>
<script src="<%=path%>/static/js/jquery-1.10.2.min.js"></script>
<script src="<%=path%>/static/js/bootstrap.min.js"></script>
<script src="<%=path%>/static/language/Simplified_Chinese/lan.js?date=7.1.0"></script>
<script src="<%=path%>/static/layer/layer.js?date=7.1.0"></script>
<script src="<%=path%>/static/js/public.js?version=7.1.0"></script>
<script src="<%=path%>/static/js/public_backup.js?version=7.1.0"></script>
<script src="<%=path%>/static/codemirror/lib/codemirror.js?version=7.1.0"></script>

<script type="text/javascript" src="js/bt_upload.js?version=7.1.0"></script>
<script src="<%=path%>/static/js/database.js?date=7.1.0"></script>
<script type="text/javascript">
    bt.set_cookie('backup_path', "/www/backup");


    database.get_list();


</script>
<script src="<%=path%>/static/js/upload.js?date=7.1.0"></script>

<script type="text/javascript">
    if (navigator.appName == "Microsoft Internet Explorer" && parseInt(navigator.appVersion.split(";")[1].replace(/[ ]/g, "").replace("MSIE", "")) < 9) {
        $(".main-content").css("margin-top", "50px");
        $('.top-tips').show();
    }
    $("#setBox").click(function () {
        if ($(this).prop("checked")) {
            $("input[name=id]").prop("checked", true);
        } else {
            $("input[name=id]").prop("checked", false);
        }
    });
    setCookie('order', 'id desc');
    var is_files_html = false;
    var task_open = 0;
    var task_close = false;
    if ($(".current").attr("id") == 'memuAfiles') {
        is_files_html = true;
    }
    function task_stat(my_init) {
        if (!my_init) {
            my_init = 0;
            if (task_open) return;
        }
        if (task_close) return;
        $.post('/task?action=get_task_lists', { status: -3 }, function (task_list) {
            if (task_list.length == 0) {
                if (my_init && is_files_html) GetFiles(getCookie('Path'));
                if (task_open) {
                    layer.close(task_open);
                    task_open = false;
                }
                return;
            }

            console.log(task_list.length)
            var msg_body = '';
            var is_add = false;
            for (var i = 0; i < task_list.length; i++) {
                if (task_list[i]['status'] == -1) {
                    if (!task_open || !$(".message-list").attr("class")) {
                        show_task();
                    }

                    if (task_list[i]['type'] == '1') {
                        msg_body += '<div class="mw-con">\
		                                <ul class="waiting-down-list">\
			                                <li>\
				                                <div class="down-filse-name"><span class="fname" style="width:80%;" title="正在下载: '+ task_list[i].shell + '">正在下载: ' + task_list[i].shell + '</span><span style="position: absolute;left: 84%;top: 25px;color: #999;">' + task_list[i].log.pre + '%</span><span class="btlink" onclick="remove_task(' + task_list[i].id + ')" style="position: absolute;top: 25px;right: 20px;">取消</span></div>\
				                                <div class="down-progress"><div class="done-progress" style="width:'+ task_list[i].log.pre + '%"></div></div>\
				                                <div class="down-info"><span class="total-size"> '+ task_list[i].log.used + '/' + ToSize(task_list[i].log.total) + '</span><span class="speed-size">' + (task_list[i].log.speed == 0 ? '正在连接..' : task_list[i].log.speed) + '/s</span><span style="margin-left: 20px;">预计还要: ' + task_list[i].log.time +'</span></div>\
			                                </li>\
	                                        </ul>\
	                                    </div>'
                    } else {
                        msg_body += '<div class="mw-title"><span style="max-width: 88%;display: block;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">' + task_list[i].name + ': ' + task_list[i].shell + '</span><span class="btlink" onclick="remove_task(' + task_list[i].id + ')"  style="position: absolute;top: 10px;right: 15px;">取消</span></div>\
	                                    <div class="mw-con codebg">\
		                                    <code>'+ task_list[i].log +'</code>\
	                                    </div>'

                    }

                } else {
                    if (!is_add) {
                        msg_body += '<div class="mw-title">等待执行任务</div><div class="mw-con"><ul class="waiting-list">';
                        is_add = true;
                    }
                    msg_body += '<li><span class="wt-list-name" style="width: 90%;">' + task_list[i].name + ': ' + task_list[i].shell + '</span><span class="mw-cancel" onclick="remove_task(' + task_list[i].id + ')">X</span></li>';
                }
            }
            if (task_open) {
                if (is_add) {
                    msg_body += '</ul></div>';
                }
                $(".message-list").html(msg_body);
            }


            if (my_init > 3) {
                if (is_files_html) GetFiles(getCookie('Path'));
                my_init = 1;
            }
            my_init +=1
            setTimeout(function () { task_stat(my_init); }, 1000);
        });
    }
    function show_task() {
        task_open = layer.open({
            type: 1,
            title: "实时任务队列",
            area: '500px',
            closeBtn: 2,
            shadeClose: false,
            shade: false,
            offset: 'auto',
            content: '<div style="margin: 10px;" class="message-list"></div>',
            cancel: function () {
                task_close = true;
            }
        });
    }
    function remove_task(id) {
        loadT = layer.msg('正在取消任务...', { time: 0, icon: 16, shade: [0.3, '#000'] });
        $.post('/task?action=remove_task', { id: id }, function (rdata) {
            layer.close(loadT)
            layer.msg(rdata.msg);
        });
    }
    loadScript([
        '<%=path%>/static/laydate/laydate.js',
        '<%=path%>/static/js/jquery.qrcode.min.js',
        '<%=path%>/static/js/clipboard.min.js'
    ],function(e){

    });
    task_stat();

</script>
</body>
</html>