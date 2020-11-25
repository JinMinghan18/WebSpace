package cn.edu.zjut.po;

public class ItemBasic {
    private String isbn;
    private String title;
    private String description;
    private Float cost;
    public ItemBasic(){    }
    public ItemBasic(String isbn){
        this.isbn = isbn;
    }

    public ItemBasic(String isbn, String title, String description, Float cost) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.cost = cost;
    }

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

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
