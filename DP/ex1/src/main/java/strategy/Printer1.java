package strategy;

import strategy.Impl.NoDiscount;

public class Printer1 extends Printer{
    public Printer1(double price){
        super();
        super.setDiscount(new NoDiscount());
        super.setPrice(price);
    }
}
