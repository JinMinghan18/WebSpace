function register_check() {
    var myid=document.getElementById("myid")
    var mname= document.getElementById("mname");
    var password = document.getElementById("password");
    var email = document.getElementById("email");
    var phone_number = document.getElementById("phone_number");


    var pwdRegex = new RegExp('(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{8,15}');//密码
    var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
    var strReg=/^\w+((-\w+)|(\.\w+))*\@{1}\w+\.{1}\w{2,4}(\.{0,1}\w{2}){0,1}/ig;//邮箱格式
    
    if(myid.value == "" || myid.value == "请输入用户名") {
        alert("用户名不能为空")
        return false;
    }
    else if(password.value == "" || password.value == "请输入密码"){
        alert("密码不能为空");
        return false;
    }
    else if(mname.value == "" || mname.value == "请输入姓名"){
        alert("姓名不能为空");
        return false;
    }
    else if(phone_number.value == "" || phone_number.value == "请输入手机号"){
        alert("手机号不能为空");
        return false;
    }
    else if(email.value == "" || email.value == "请输入电子邮箱"){
        alert("邮箱不能为空");
        return false;
    }
    else if(phone_number.value.charAt(0)!='1' || phone_number.value.length != 11){
        alert("手机号格式错误!");
        return false;
    }
    else if (!pwdRegex.test(password.value)) {
        alert("您的密码复杂度太低（密码中必须包含字母、数字、特殊字符），请修改密码！");
        return false;
    }
    else if(email.value.search(strReg)==-1){
        alert("邮箱格式错误!");
        return false;
    }
    else if(!reg.test(mname.value)){
        alert("姓名必须为中文!");
        return false;
    }

}