package com.edu.zjut.dao;

import org.hibernate.Session;

public class BaseHibernateDao {
    public Session getSession(){
        return HibernateUtil.getSession();
    }

}
