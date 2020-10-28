package cn.edu.zjut.bean;

public class ItemOrder {
    private Item item;
    private int numItems;
    public ItemOrder(Item item) {
        setItem(item);
        setNumItems(1);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }
}
