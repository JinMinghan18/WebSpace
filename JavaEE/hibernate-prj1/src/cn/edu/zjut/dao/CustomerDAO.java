package cn.edu.zjut.dao;

import cn.edu.zjut.po.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class CustomerDAO {
    private Log log = LogFactory.getLog(CustomerDAO.class);
    public List findByHql(String hql){
        log.debug("finding LoginUser instance by hql");
        SessionFactory sf = new Configuration()
                .configure().buildSessionFactory();
        Session session = sf.openSession();
        try{
            String queryString = hql;
            Query queryObject = session.createQuery(queryString);
            return queryObject.list();
        }catch (RuntimeException re){
            log.error("find by hql failed",re);
            throw  re;
        }finally {
            session.close();
        }
    }

}
