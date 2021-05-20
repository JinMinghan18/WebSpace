package strategy.Impl;

import strategy.Discount;

public class FixedDiscount implements Discount {
    @Override
    public double discount(double price) {
        show(price-10);
        return price-10;
    }

    @Override
    public void show(double price) {
        System.out.println("此商品优惠10元，总价为"+price);
    }
}
