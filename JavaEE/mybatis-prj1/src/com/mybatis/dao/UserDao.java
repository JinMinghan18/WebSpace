package com.mybatis.dao;

import com.mybatis.po.MyUser;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public MyUser selectUserById2(Integer id);
    public List<MyUser> selectAllUser2(Map map);
    public int addUser(MyUser user);
    public int updateUser(MyUser user);
    public int deleteUser(MyUser user);
}
