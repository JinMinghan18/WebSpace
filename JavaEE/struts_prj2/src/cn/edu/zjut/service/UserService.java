package cn.edu.zjut.service;

import cn.edu.zjut.bean.UserBean;

import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class UserService {
    public boolean login(UserBean loginUser){
        if(loginUser.getAccount().equals(loginUser.getPassword())){
            return true;
        }
        return false;
    }
    public boolean register(UserBean regUser){
        System.out.println(regUser.getAccount()+"  "+regUser.getPassword()+ " "+regUser.getRepassword());
//        SimpleDateFormat format = new SimpleDateFormat()
        if(!regUser.getAccount().equals("")){// && regUser.getPassword().equals(regUser.getRepassword())
            return true;
        }
        return false;
    }
}
