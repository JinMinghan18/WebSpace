function checkForm() {
    var id = document.getElementsByName("id");
    var password = document.getElementsByName("password");
    if(form.id.value == ""){
        alert("请输入用户名");
        return false;
    }
    else if(form.password.value == ""){
        alert("请输入密码");
        return false;
    }
}