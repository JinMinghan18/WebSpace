package com.book;

public class JavaBeans {
    private String bid;
    private String title;
    private String author;

    JavaBeans(){}
    public JavaBeans(String bid, String title ,String author){
        this.author=author;
        this.bid = bid;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBid() {
        return bid;
    }
}
