<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/10
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>健康码申请</title>
    <script type="text/javascript" src="<%=path%>/JS/checkform.js"></script>
</head>
<body style="background-color: #444444;">
<form action="CheckHealthCodeServlet" method="post" name="form" onsubmit="return check_form()" style=" border-radius: 4px;margin: 0px auto;background-color: #f2f2f2;width: 373px;height: 1150px">
    <h4 align="center">师生健康打卡</h4>
    <div style="background-color: white">
        <table  style="background-color: white">
            <tr>
                <td>姓名:</td><td><input type="text" name="name"  value="${student.name}${teacher.name}" readonly style="width: 200px;border-radius: 4px"></td>
            </tr>
            <tr>
                <td>身份证号:</td><td><input type="text" name="id" value="${student.id}${teacher.id}" readonly style="width: 200px;border-radius: 4px"></td>
            </tr>
            <tr>
                <td>请输入学号(工号):</td><td><input type="text" name="school_id" value="${student.school_id}${teacher.school_id}" readonly style="width: 200px;border-radius: 4px"></td>
            </tr>
            <tr>
                <td>请输入手机号:</td><td><input type="tel" name="tel" placeholder="请输入手机号" style="width: 200px;border-radius: 4px"></td>
            </tr>
        </table>
    </div><br>


    <%--近期（14天内）是否去过湖北省或重点疫区?--%>
    <div style="background-color: white">

        <span>近期（14天内）是否去过湖北省或重点疫区</span><br>
        <img src="<%=path%>/images/single_select.png" style="width: 30px;height: 15px;">
        <table>
            <tr>
                <td width="305px"><input type="radio" name="q1" value="yes"></td><td style="width: 95%;border-bottom: 1px solid rgba(0,0,0,0.15)">是</td>
            </tr>
            <tr>
                <td><input type="radio" name="q1" value="no"></td><td width="95%">否</td>
            </tr>
        </table>
    </div><br>
    <div style="background-color: white">
        <span style="width: 305px">近期（14天内）是否去过国外</span><br>
        <img src="<%=path%>/images/single_select.png" style="width: 30px;height: 15px;">
        <table>
            <tr>
                <td width="305px"><input type="radio" name="q2" value="yes"></td><td style="width: 95%;border-bottom: 1px solid rgba(0,0,0,0.15)">是</td>
            </tr>
            <tr>
                <td><input type="radio" name="q2" value="no"></td><td width="95%">否</td>
            </tr>
        </table>
    </div><br>
    <div style="background-color: white">
        <span style="width: 305px">近期（14天内）是否接触过新冠确诊病人或疑似病人</span><br>
        <img src="<%=path%>/images/single_select.png" style="width: 30px;height: 15px;">
        <table>
            <tr>
                <td width="305px"><input type="radio" name="q3" value="yes"></td><td style="width: 95%;border-bottom: 1px solid rgba(0,0,0,0.15)">是</td>
            </tr>
            <tr>
                <td><input type="radio" name="q3" value="no"></td><td width="95%">否</td>
            </tr>
        </table>
    </div><br>
    <div style="background-color: white">
        <span style="width: 305px">是否被卫生部门确认为新冠肺炎确诊病例或疑似病例</span><br>
        <img src="<%=path%>/images/single_select.png" style="width: 30px;height: 15px;">
        <table>
            <tr>
                <td width="305px"><input type="radio" name="q4" value="yes"></td><td style="width: 95%;border-bottom: 1px solid rgba(0,0,0,0.15)">是</td>
            </tr>
            <tr>
                <td><input type="radio" name="q4" value="no"></td><td width="95%">否</td>
            </tr>
        </table>
    </div><br>
    <div style="background-color: white">
        <span>&nbsp;当前健康情况(若有以下情况，请在方框中勾选)</span><br/>
        &nbsp;<img src="<%=path%>/images/multi_select.png" style="width: 30px;height: 15px;">
        <table style="height: 280px">
            <tr>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);width: 373px"><input type="checkbox" name="situation" value="nothing_wrong">无异常</td>
            </tr>
            <tr>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);width: 373px"><input type="checkbox" name="situation" value="weak">乏力 </td>
            </tr>
            <tr>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);width: 373px"><input type="checkbox" name="situation" value="cough">干咳</td>
            </tr>
            <tr>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);width: 373px"><input type="checkbox" name="situation" value="nasal_obstration">鼻塞</td>
            </tr>
            <tr>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);width: 373px"><input type="checkbox" name="situation" value="shed_tears">流涕</td>
            </tr>
            <tr>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);width: 373px"><input type="checkbox" name="situation" value="sore_throat">咽痛</td>
            </tr>
            <tr>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);width: 373px"><input type="checkbox" name="situation" value="lax">腹泻</td>
            </tr>
        </table>
    </div><br>
    <div style="background-color: white">
        <span>&nbsp;本人郑重承诺:</span><br/>
        <table style="height: 120px">
            <tr>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);"><input type="checkbox" name="promise" value="promise1"></td>
                <td style="border-bottom: 1px solid rgba(0,0,0,0.15);">本人郑重承诺：填报信息真实，愿意承担相应的法律责任</td>
            </tr>
        </table>
    </div><br>

    <div>
        <tr><td><div style="text-align:center"><input type="submit" name="submit" value="提交" style="width: 90%;background-color: #3396FB;border-radius:15px;border: none"></div></td></tr>
    </div>
</form>
</body>
</html>
