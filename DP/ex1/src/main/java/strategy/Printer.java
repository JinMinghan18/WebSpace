package strategy;

public abstract class Printer {
    public double price;
    private Discount discount;
    public Printer(){}

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public double getPrice(double price) {
        return this.discount.discount(price);
    }
}
