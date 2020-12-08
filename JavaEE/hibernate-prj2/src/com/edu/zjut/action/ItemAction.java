package com.edu.zjut.action;

import com.edu.zjut.service.ItemService;

import java.util.List;

public class ItemAction{
    private List items;

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
    public String findItems(){
        ItemService itemServ = new ItemService();
        items=itemServ.findByHql();
        System.out.println("Item Action executed");
        return "success";
    }
}
