package strategy;

import strategy.Impl.FixedDiscount;
import strategy.Impl.NoDiscount;
import strategy.Impl.percentDiscount;

public class Test {
    public static void main(String[] args) {
        Printer1 printer1 = new Printer1(100);
        printer1.setDiscount(new NoDiscount());
        printer1.getPrice(100);
        Printer2 printer2 = new Printer2(100);
        printer2.setDiscount(new FixedDiscount());
        printer2.getPrice(100);
        Printer3 printer3 = new Printer3(100);
        printer3.setDiscount(new percentDiscount());
        printer3.getPrice(100);

    }
}
