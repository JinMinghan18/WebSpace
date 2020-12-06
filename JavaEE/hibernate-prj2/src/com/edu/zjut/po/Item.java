package com.edu.zjut.po;


import java.sql.Blob;
import java.util.Objects;

public class Item {
    private String isbn;
    private String title;
    private String description;
    private double cost;
    private Blob image;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.cost, cost) == 0 &&
                Objects.equals(isbn, item.isbn) &&
                Objects.equals(title, item.title) &&
                Objects.equals(description, item.description) &&
                Objects.equals(image, item.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, description, cost, image);
    }
}
