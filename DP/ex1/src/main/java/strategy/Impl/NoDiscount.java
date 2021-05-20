package strategy.Impl;

import strategy.Discount;

public class NoDiscount implements Discount {
    @Override
    public double discount(double price) {
        show(price);
        return price;
    }
    @Override
    public void show(double price){
        System.out.println("此商品无折扣，总价为"+price);
    }
}
