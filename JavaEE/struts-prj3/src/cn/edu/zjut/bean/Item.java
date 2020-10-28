package cn.edu.zjut.bean;

public class Item {
    private String itemID;
    private String name;
    private String description;
    private double cost;
    public Item(String itemID, String name, String description, double cost){
        setItemID(itemID);
        setName(name);
        setDescription(description);
        setCost(cost);
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
