package cn.edu.zjut.service;

import cn.edu.zjut.bean.UserBean;

import javax.swing.text.StyledEditorKit;

public class UserService {
    public boolean login(UserBean loginUser){
        if(loginUser.getAccount().equals(loginUser.getPassword())){
            return true;
        }
        return false;
    }
}
