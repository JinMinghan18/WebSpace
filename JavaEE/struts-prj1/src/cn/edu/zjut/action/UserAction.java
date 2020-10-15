package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;

import javax.jws.soap.SOAPBinding;

public class UserAction {
    private UserBean loginUser;

    public UserBean getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }
    public String execute(){
        UserService userService = new UserService();
        if(userService.login(loginUser)){
            return "success";
        }
        return "fail";
    }
}
