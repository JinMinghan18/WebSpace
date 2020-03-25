//检验账号是否符合规范，密码是否正确
function check() {
    var memberName = document.getElementById("memberName");
    var userName = document.getElementById("userName");
    var password = document.getElementById("password");
    var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
    if(memberName.value == ""|| memberName.value == "请输入会员名"){
        alert("会员名不能为空！");
        return false;
    }
    else if(userName.value == ""|| userName.value == "请输入用户名"){
        alert("用户名不能为空！");
        return false;
    }
    else if(password.value == ""||password.value == "请输入密码"){
        alert("密码不能为空！");
        return false;
    }
    if(!reg.test(memberName.value)){
        alert("会员名必须为中文");
        return false;
    }
}