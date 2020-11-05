package cn.edu.zjut.service;

import cn.edu.zjut.dao.ItemDao;
import cn.edu.zjut.po.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private List items = new ArrayList();
    public List getAllItems(){
        ItemDao dao = new ItemDao();
        List items = dao.findAll();
        return items;
    }
}
