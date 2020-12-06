package com.edu.zjut.service;

import com.edu.zjut.dao.CustomerDao;
import com.edu.zjut.po.Customer;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Transaction;

import javax.swing.*;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String,Object> request,session;

    public boolean login(Customer loginUser){
        ActionContext ctx = ActionContext.getContext();
        session = (Map)ctx.getSession();
        request = (Map)ctx.get("request");
        String account = loginUser.getAccount();
        String password = loginUser.getPassword();
        String hql = "from Customer as user where account='" +account+
                "' and password='"+password+"'";
        CustomerDao dao = new CustomerDao();
        List list = dao.findByHql(hql);
        dao.getSession().close();
        if(list.isEmpty()){
            return false;
        }
        else{
            session.put("user",account);
            request.put("tip","登陆成功！");
            loginUser = (Customer)list.get(0);
            request.put("loginUser",loginUser);
            return true;
        }
    }
    public boolean register(Customer loginUser){
        ActionContext ctx = ActionContext.getContext();
        session = (Map)ctx.getSession();
        request = (Map)ctx.get("request");
        CustomerDao dao = new CustomerDao();
        Transaction transaction = null;
        try{
            transaction = dao.getSession().beginTransaction();
            dao.save(loginUser);
            transaction.commit();
            request.put("tip","注册成功！");
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            return false;
        }finally {
            dao.getSession().close();
        }
    }
    public boolean update(Customer loginUser){
        ActionContext ctx = ActionContext.getContext();
        session = (Map)ctx.getSession();
        request = (Map)ctx.get("request");
        CustomerDao dao = new CustomerDao();
        Transaction transaction = null;
        try{
            transaction = dao.getSession().beginTransaction();
            dao.update(loginUser);
            transaction.commit();
            request.put("tip","更新个人信息成功");
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            return false;
        }finally {
            dao.getSession().close();
        }
    }
    public boolean delete(Customer loginUser){
        ActionContext ctx = ActionContext.getContext();
        session = (Map)ctx.getSession();
        request = (Map)ctx.get("request");
        CustomerDao dao = new CustomerDao();
        Transaction transaction = null;
        try{
            transaction = dao.getSession().beginTransaction();
            dao.delete(loginUser);
            transaction.commit();
            request.put("tip","删除信息成功，请重新登录");
            return true;
        }catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
            return false;
        }finally {
            dao.getSession().close();
        }
    }

}
