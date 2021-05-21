package ObMod.ObserverImpl;


import ObMod.DisplayElement;
import ObMod.Observer;
import ObMod.subject;

public class CurrentStock implements Observer, DisplayElement {
    private subject stockData;
    private double price;
    private double hprice;
    private double lprice;

    @Override
    public void display() {

    }

    @Override
    public void update(float price, float hprice, float lprice) {

    }
}
