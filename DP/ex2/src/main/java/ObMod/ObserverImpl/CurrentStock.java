package ObMod.ObserverImpl;


import ObMod.DisplayElement;
import ObMod.Observer;
import ObMod.subject;

public class CurrentStock implements Observer, DisplayElement {
    private subject stockData;
    private double price;
    public CurrentStock(subject stockData){
        this.stockData = stockData;
        stockData.addObservers(this);
    }

    @Override
    public void display() {
        System.out.println("当前的股票价格为："+price);
    }

    @Override
    public void update(double price) {
        this.price = price;
        display();
    }
}
