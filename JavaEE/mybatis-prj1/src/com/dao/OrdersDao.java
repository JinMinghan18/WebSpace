package com.dao;

import com.mybatis.po.Orders;

import java.util.List;

public interface OrdersDao {
    public List<Orders> selectOrdersById(Integer id);
}
