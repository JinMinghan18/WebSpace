package cn.edu.zjut.po;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Objects;

@Entity
public class Item {
//    private String isbn;
//    private String title;
    private ItemPK ipk;
    private String description;
    private Double cost;
    private Blob image;

    public ItemPK getIpk() {
        return ipk;
    }

    public void setIpk(ItemPK ipk) {
        this.ipk = ipk;
    }

    //    @Id
//    @Column(name = "ISBN")
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    @Basic
//    @Column(name = "title")
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Lob
    @Basic
    @Column(name = "image")
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
        return Objects.equals(ipk,item.ipk) &&
//                Objects.equals(isbn, item.isbn) &&
//                Objects.equals(title, item.title) &&
                Objects.equals(description, item.description) &&
                Objects.equals(cost, item.cost) &&
                Objects.equals(image, item.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipk, description, cost, image);
    }
}
