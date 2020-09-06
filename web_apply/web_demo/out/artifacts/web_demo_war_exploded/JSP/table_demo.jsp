<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>
<head>
    <meta charset="UTF-8">
    <title>��ʾ��</title>
    <!-- CSS only -->
    <link href="../bootstrap-4.5.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../bootstrap-4.5.2-dist/js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="../bootstrap-4.5.2-dist/js/bootstrap.js"></script>
    <script>
        function deleteRow(r) {
            var i = r.parentNode.parentNode.rowIndex
            document.getElementById('t').deleteRow(i)
        }
    </script>

    <style>
        body{
            font-size: 14px;
        }
        .t{
            font-size: 14px;
            color: #343434;
            width: 100%;
            text-align: center;
            table-layout: fixed;
            border: 1px solid #ebebeb;
            border-collapse: collapse;
        }
        .t tr{
            height: 60px;
        }
        .t tr th,.t tr td{
            border: 1px solid #ebebeb;
        }
        .t tr:hover{
            background-color: #e2f9ff;
        }
        .t table tr th,.t table tr td{
            border: 0;
        }
        .t table{
            width: 100%;
        }
        .double_tr{
            background-color: #f4f4f4;
        }
        a{
            text-decoration: none;
            color: black;
        }
        .query_details{
            background-color: transparent;
            border-style: none;
            outline: none;
        }
        .query_details:hover{
            color: blue;

        }
        .edit{
            background-color: transparent;
            border-style: none;
            outline: none;
        }
        .edit:hover{
            color: green;
        }
        .del{
            background-color: transparent;
            border-style: none;
            outline: none;
        }
        .del:hover{
            color: red;
        }
        @media (min-width:992px){.modal-lgg,.modal-xl{max-width:830px}}
        @media (min-width:992px){.modal-smm{max-width:430px;max-height: 175px;}}
        .edit_table{
            font-size: 14px;
            color: #343434;
            width: 100%;
            text-alignd:left;
            table-layout: fixed;
            border:none;
        }
        .modal_style{
            box-shadow: 0 4px 10px 0 rgba(0,0,0,10);
        }
        .radio_a +label{
            font-size: 14px;
        }
        .radio_a:checked + label{
            color: deepskyblue;
            font-size: 14px;
        }
        .radio_b +label{
            font-size: 14px;
        }
        .radio_b:checked + label{
            color: deepskyblue;
            font-size: 14px;
        }
        .btn_check_style{
            width: 100px;
            height: 38px;
            font-family: PingFang SC Regular;
            font-size: 14pt;
            color: #FFF;
            background-color: #08B4FF;
            border-radius: 3px;
            border: none;
        }
        .btn_check_style:hover{
            background-color: #07ACF5;
        }
        .btn_check_style:active{
            background-color: #07ACF5;
            box-shadow: 0 1px 4px 0 rgba(0,0,0,20);
        }
        .btn_check_style:visited{
            background-color: #08B4FF;
            box-shadow: none;
        }
        .btn_cancel_style{
            width: 100px;
            height: 38px;
            font-family: PingFang SC Regular;
            font-size: 14pt;
            color: #B8B8B8;
            background-color: #F8F8F8;
            border-radius: 3px;
            border: none;
        }
        .btn_cancel_style:hover{
            background-color: #FFF;
        }
        .btn_cancel_style:active{
            background-color: #F8F8F8;
            box-shadow: 0 1px 4px 0 rgba(0,0,0,20);
        }
        .btn_cancel_style:visited{
            background-color: #08B4FF;
            box-shadow: none;
        }


    </style>
</head>
<body>
<div class="modal fade modal_style" id="detail${1}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lgg" style="width: 830px;">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">����</h4>
            </div>
            <div class="modal-body">��������</div>
            <div class="modal-footer">
                <button type="button"  data-dismiss="modal" class="btn_check_style">ȷ��</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<table class="t" id="t">
    <thead>
    <tr style="background-color: #FFFFFF">
        <th width="5%">����</th>
        <th>ѧУ����</th>
        <th>�ֻ�</th>
        <th>����</th>
        <th>�������</th>
        <th>�������</th>
        <th>����������</th>
        <th>����������</th>
        <th width="25%">����</th>
    </tr>
    </thead>
    <tbody>
    <tr class="double_tr" >
        <td style="color: red">TOP1</td>
        <td>�㽭��ҵ��ѧ</td>
        <td>15858238365</td>
        <td>1099461301@qq.com</td>
        <td>111</td>
        <td>12312</td>
        <td>5000</td>
        <td>6000</td>
        <td>
            <button class="query_details" data-toggle="modal" data-target="#detail${1}">�鿴��ϸ</button>
<%--            ģ̬��--%>

            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <button class="edit" data-target="#edit${1}" data-toggle="modal">�༭</button>
            <div class="modal fade" id="edit${1}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lgg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h6 class="modal-title">�༭����Ա</h6>
                        </div>
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <td width="12%">���ݴ���</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td width="12%">��ֽ����</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>ֽ������</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>ֽ�ſ��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>ֽ�Ÿ߶�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�ϱ߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>��߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�±߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>�ұ߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>Ĭ�ϴ�ӡ��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>˵��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�Ƿ�ͣ��</td>
                                    <td>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input name="stopOrNot" type="radio" placeholder="����" class="radio_a" id="open${1}"><label for="open${1}">����</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input name="stopOrNot" type="radio" class="radio_b" id="stop${1}"><label for="stop${1}" >ֹͣ</label>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn_check_style" data-dismiss="modal">ȷ��</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <button class="del" data-toggle="modal" data-target="#del${1}">ɾ��</button>
            <div class="modal fade" id="del${1}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-smm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">��ʾ</h4>
                        </div>
                        <div class="modal-body">ȷ��Ҫɾ���ù���?</div>
                        <div class="modal-footer">
                            <button type="button" class="btn_cancel_style" data-dismiss="modal">ȡ��</button>
                            <button type="button" class="btn_check_style" data-dismiss="modal">ȷ��</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

        </td>
    </tr>
    <tr>
        <td style="color: #ffbf00">TOP2</td>
        <td>�㽭��ҵ��ѧ</td>
        <td>15858238365</td>
        <td>1099461301@qq.com</td>
        <td>111</td>
        <td>2335</td>
        <td>5000</td>
        <td>6000</td>
        <td>
            <button class="query_details" data-toggle="modal" data-target="#detail${2}">�鿴��ϸ</button>
<%--            ģ̬��--%>
            <div class="modal fade" id="detail${2}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lgg" style="width: 830px;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">����</h4>
                        </div>
                        <div class="modal-body">��������2</div>
                        <div class="modal-footer">
                            <button type="button" data-dismiss="modal" class="btn_check_style">ȷ��</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="edit" data-target="#edit${2}" data-toggle="modal">�༭</button>
            <div class="modal fade" id="edit${2}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lgg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h6 class="modal-title">�༭����Ա</h6>
                        </div>
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <td width="12%">���ݴ���</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td width="12%">��ֽ����</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>ֽ������</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>ֽ�ſ��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>ֽ�Ÿ߶�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�ϱ߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>��߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�±߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>�ұ߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>Ĭ�ϴ�ӡ��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>˵��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�Ƿ�ͣ��</td>
                                    <td>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input name="stopOrNot" type="radio" placeholder="����" class="radio_a" id="open${1}"><label for="open${1}">����</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input name="stopOrNot" type="radio" class="radio_b" id="stop${1}"><label for="stop${1}" >ֹͣ</label>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn_check_style">ȷ��</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="del" data-target="#del${2}" data-toggle="modal">ɾ��</button>
            <div class="modal fade" id="del${2}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-smm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">��ʾ</h4>
                        </div>
                        <div class="modal-body">ȷ��Ҫɾ���ù���?</div>
                        <div class="modal-footer">
                            <button type="button" class="btn_cancel_style" data-dismiss="modal">ȡ��</button>
                            <button type="button" class="btn_check_style" data-dismiss="modal">ȷ��</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
        </td>
    </tr>
    <tr class="double_tr">
        <td style="color: blue">TOP3</td>
        <td>�㽭��ҵ��ѧ</td>
        <td>15858238365</td>
        <td>1099461301@qq.com</td>
        <td>111</td>
        <td>1232</td>
        <td>5000</td>
        <td>6000</td>
        <td><button class="query_details" data-toggle="modal" data-target="#detail${3}">�鿴��ϸ</button>
            <div class="modal fade" id="detail${3}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lgg" style="width: 830px;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">����</h4>
                        </div>
                        <div class="modal-body">��������3</div>
                        <div class="modal-footer">
                            <button type="button" class="btn_check_style" data-dismiss="modal">ȷ��</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="edit" data-toggle="modal" data-target="#edit${3}">�༭</button>
            <div class="modal fade" id="edit${3}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lgg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h6 class="modal-title">�༭����Ա</h6>
                        </div>
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <td width="12%">���ݴ���</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td width="12%">��ֽ����</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>ֽ������</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>ֽ�ſ��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>ֽ�Ÿ߶�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�ϱ߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>��߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�±߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>�ұ߾�</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>Ĭ�ϴ�ӡ��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                </tr>
                                <tr>
                                    <td>˵��</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="������" size="25px"></td>
                                    <td>�Ƿ�ͣ��</td>
                                    <td>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input name="stopOrNot" type="radio" placeholder="����" class="radio_a" id="open${1}"><label for="open${1}">����</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input name="stopOrNot" type="radio" class="radio_b" id="stop${1}"><label for="stop${1}" >ֹͣ</label>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn_check_style" data-dismiss="modal">ȷ��</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="del" data-toggle="modal" data-target="#del${3}">ɾ��</button>
            <div class="modal fade" id="del${3}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-smm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">��ʾ</h4>
                        </div>
                        <div class="modal-body">ȷ��Ҫɾ���ù���?</div>
                        <div class="modal-footer">
                            <button type="button" class="btn_cancel_style" data-dismiss="modal">ȡ��</button>
                            <button type="button" class="btn_check_style" data-dismiss="modal">ȷ��</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
        </td>

    </tr>
    </tbody>
</table>

</body>
</html>