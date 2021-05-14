package strategy;

import strategy.Impl.NoDiscount;

public class Printer3 extends Printer{
    public Printer3(double price){
        super();
        super.setDiscount(new NoDiscount());
        super.setPrice(price);
    }
}
