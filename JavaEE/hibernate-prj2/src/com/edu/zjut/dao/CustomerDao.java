package com.edu.zjut.dao;

import com.edu.zjut.po.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.query.Query;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.List;

public class CustomerDao extends HibernateUtil{
    private Log log = LogFactory.getLog(CustomerDao.class);
    public List findByHql(String hql){
        log.debug("finding Customer instance by hql");
        try{
            String QueryString = hql;
            Query queryObject = getSession().createQuery(QueryString);
            return queryObject.list();
        }catch (RuntimeException re){
            log.error("find by hql failed",re);
            throw re;
        }
    }
    public void save(Customer instance){
        log.debug("saving Customer instance");
        try{
            getSession().save(instance);
            log.debug("save Successful");
        }catch (RuntimeException re){
            log.error("save failed",re);
            throw re;
        }
    }
    public void update(Customer instance){
        log.debug("update Customer instance");
        try{
            getSession().update(instance);
            log.debug("update successful");
        }catch (RuntimeException re){
            log.error("update failed",re);
            throw re;
        }
    }
    public void delete(Customer instance){
        log.debug("delete Customer instance");
        try{
            getSession().delete(instance);
            log.debug("delete successful");
        }catch (RuntimeException re){
            log.error("delete failed",re);
            throw re;
        }
    }

}
