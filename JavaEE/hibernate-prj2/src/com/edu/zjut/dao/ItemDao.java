package com.edu.zjut.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDao extends BaseHibernateDao{
    private static final Log log = LogFactory.getLog(ItemDao.class);

    public List findByHql(String hql){
        log.debug("finding Item insatance by hql");
        try {
            String querySting = hql;
            Query queryObject = getSession().createQuery(querySting);
            return queryObject.list();
        }catch (RuntimeException re){
            log.error("find by hql failed",re);
            throw re;
        }
    }

}
