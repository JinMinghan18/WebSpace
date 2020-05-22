package com.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String pname;
    private String brand;
    private float price;
    private int stock;

    public Product(){}
    public Product(int id,String pname,String brand,
                   float price,int stock){
        this.id = id;
        this.pname = pname;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public String getBrand() {
        return brand;
    }

    public String getPname() {
        return pname;
    }

    public float getPrice() {
        return price;
    }
}
