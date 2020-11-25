package com.mybatis.po;

public class Orders {
    private Integer order_id;
    private Integer id;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    @Override
    public String toString() {
        return "Orders [id=" + id + ",order_id=" + order_id + "]";
    }
}
