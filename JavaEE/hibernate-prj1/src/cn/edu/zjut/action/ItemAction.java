package cn.edu.zjut.action;

import cn.edu.zjut.po.Item;
import cn.edu.zjut.service.ItemService;
import cn.edu.zjut.service.UserService;

import java.util.List;

public class ItemAction {
    private Item Items;

    public Item getItems() {
        return Items;
    }

    public void setItems(Item Items) {
        Items = Items;
    }
    public String getAllItems(){
        ItemService itemServ = new ItemService();

        List<Item> itemList = itemServ.getAllItems();
        return "success";
    }
}
