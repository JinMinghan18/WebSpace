package strategy;

import strategy.Impl.NoDiscount;

public class Printer1 extends Printer{
    public Printer1(){
        super();
        super.setDiscount(new NoDiscount());
        super.setPrice(price);
    }
}
