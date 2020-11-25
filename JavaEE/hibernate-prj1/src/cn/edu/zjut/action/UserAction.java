package cn.edu.zjut.action;

import cn.edu.zjut.po.Customer;
import cn.edu.zjut.service.UserService;

public class UserAction {
    private Customer loginUser;
    public Customer getLoginUser(){
        return loginUser;
    }
    public void setLoginUser(Customer loginUser){
        this.loginUser = loginUser;
    }
    public String login() {
        UserService userServ = new UserService();
        if (userServ.login(loginUser)) {
            return "success";
        }
        return "fail";
    }
    public String register(){
        UserService userService = new UserService();
        userService.register(loginUser);
        return "registerSuccess";
    }
}
