package com.mybatis.test;

import com.dao.OrdersDao;
import com.mybatis.po.Orders;

import java.util.List;

public class TestOneToMore {
    private OrdersDao ordersDao;

    public OrdersDao getOrdersDao() {
        return ordersDao;
    }

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }
    public void test1(){
        List<Orders> o1 = ordersDao.selectOrdersById(1);
        System.out.println(o1);
    }



}
