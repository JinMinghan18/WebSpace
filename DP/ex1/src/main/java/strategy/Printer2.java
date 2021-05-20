package strategy;

import strategy.Impl.FixedDiscount;
import strategy.Impl.NoDiscount;

public class
Printer2 extends Printer{
    public Printer2(double price){
        super();

        super.setDiscount(new FixedDiscount());
        super.setPrice(price);
    }
}
