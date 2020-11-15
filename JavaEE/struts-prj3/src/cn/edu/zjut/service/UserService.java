package cn.edu.zjut.service;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.exception.UserException;

import java.text.SimpleDateFormat;
import java.util.jar.JarException;
import java.util.logging.SimpleFormatter;

public class UserService {
    public boolean login(UserBean loginUser) throws Exception{
        if(loginUser.getAccount().equals("admin")){
            throw new UserException("用户名不能为admin");
        }
        if(loginUser.getPassword().toUpperCase().contains(" AND ")
            || loginUser.getPassword().toUpperCase().contains(" OR")){
            throw new java.sql.SQLException("密码不能包括' and '或' or '");
        }
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
