package strategy.Impl;

import strategy.Discount;

public class percentDiscount implements Discount {

    @Override
    public double discount(double price) {
        price = price*0.95;
        show(price);
        return price;
    }
    void show(double price){
        System.out.println("此商品折扣5%，总价为"+price);
    }
}
