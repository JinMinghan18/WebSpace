package com.edu.zjut.service;

import com.edu.zjut.dao.ItemDao;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private List items = new ArrayList();

    public  List findByHql(){
        String hql = "from com.edu.zjut.Item";
        ItemDao dao = new ItemDao();
        List list = dao.findByHql(hql);
        dao.getSession().close();
        return list;
    }

}
