package com.edu.zjut.action;

import com.edu.zjut.po.Customer;
import com.edu.zjut.service.UserService;

public class UserAction {
    private Customer loginUser;

    public Customer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Customer loginUser) {
        this.loginUser = loginUser;
    }
    public String login(){
        UserService us = new UserService();
        if(us.login(loginUser)){
            return "loginsuccess";
        }
        else return "loginfail";
    }
    public String register(){
        UserService us = new UserService();
        if(us.register(loginUser)){
            return "regsuccess";
        }
        else return "regfail";
    }
    public String update(){
        UserService us = new UserService();
        if(us.update(loginUser)){
            return "updatesuccess";
        }
        else return "updatefail";
    }
    public String delete(){
        UserService us = new UserService();
        if(us.delete(loginUser)){
            return "deletesuccess";
        }
        else return "deletefail";
    }

}
