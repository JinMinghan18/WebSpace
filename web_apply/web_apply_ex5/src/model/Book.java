package model;

public class Book {
    private String title;
    private String autuor;
    private String publisher;
    private String time;
    private String ISBN;
    private String price;

    public Book(){}
    public Book(String title,String autuor,String publisher,String time,String ISBN,String price){
        this.autuor = autuor;
        this.title = title;
        this.publisher = publisher;
        this.time = time;
        this.ISBN = ISBN;
        this.price = price;
    }
    public void setAutuor(String autuor) {
        this.autuor = autuor;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutuor() {
        return autuor;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }
}
