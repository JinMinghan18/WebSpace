package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;

import java.io.Console;

public class UserAction {
    private UserBean loginUser;
    private UserBean regUser;

    public UserBean getLoginUser() {
        return loginUser;
    }
    public UserBean getRegUser() {
        return regUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }
    public void setRegUser(UserBean regUser) {
        this.regUser = regUser;
    }

    public String login(){
        UserService userService = new UserService();
        if(userService.login(loginUser)){
            return "success";
        }
        return "fail";
    }
    public String register(){
        UserService userService = new UserService();
        if(userService.register(regUser)){
            return "success";
        }
        return "fail";
    }
    public String execute(){
        UserService userService = new UserService();
        if(loginUser !=null){
            if(userService.login(loginUser)){
                return "success";
            }
        }
        else{
            if(userService.register(regUser)){
                return "success";
            }
        }


        return "fail";

    }
}
