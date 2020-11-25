<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/20
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#btn1").click(function(){
                $('#test').load('demo_get.txt',function (responseTxt,statusTxt,xhr) {
                    if(statusTxt=="success"){
                        alert("success");
                    }
                    if(statusTxt=="error")
                        alert("error"+xhr.status+":"+xhr.statusText);
                });
            });
            $("#btn2").click(function () {
                $.get("demo_get1.asp",function (data,status) {
                    alert(data+"\n"+status);
                })
            })
        });

    </script>

</head>

<body>

<h3 id="test">请点击下面的按钮，通过 jQuery AJAX 改变这段文本。</h3>
<button id="btn1" type="button">获得外部的内容</button>
<button id="btn2" type="button">获得服务器的内容</button>


    <iframe style="width: 100%;height: 500px" id="iframeposition" src="http://www.baidu.com">

    </iframe>
</body>
</html>
