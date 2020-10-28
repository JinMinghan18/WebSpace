package cn.edu.zjut.bean;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List itemsOrdered;
    public ShoppingCart(){
        itemsOrdered = new ArrayList();
        Item item = new Item("book001","JAVAEE技术实验指导教程",
                "WEB程序设计知识回顾、"+"轻量级JAVAEE应用框架、"
                        +"企业级EJB组件编程技术、"+"JAVAEE综合应用开发.",19.95);
        ItemOrder itemOrder =new ItemOrder(item);
        itemOrder.setNumItems(2);
        itemsOrdered.add(itemOrder);
    }
    public List getItemsOrdered(){
        return (itemsOrdered);
    }
    public synchronized void addItem(String itemID){}
    public synchronized void setNumOrdered(String itemID,int numOrdered){}
}
