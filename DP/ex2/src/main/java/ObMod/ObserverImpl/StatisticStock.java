package ObMod.ObserverImpl;

import ObMod.DisplayElement;
import ObMod.Observer;
import ObMod.SubjectImpl.StockData;
import ObMod.subject;

import java.util.ArrayList;
import java.util.Vector;

public class StatisticStock implements Observer, DisplayElement {
    private subject stockData;
    private double price;
    private int count = 0;
    private double avgprice;
    private double hprice;
    private double lprice;
//    Vector<Double> list = new Vector<Double>();
    public StatisticStock(subject stockData){
        this.stockData = stockData;
        stockData.addObservers(this);
    }

    @Override
    public void display() {
        System.out.println("股票均价为：" + avgprice);
        System.out.println("股票最高价为：" + hprice);
        System.out.println("股票最低价为：" + lprice);
    }

    @Override
    public void update(double price) {
        double sum = avgprice*count+price;
        count++;
        if(count == 1)
            this.lprice = price;
        this.avgprice = sum/count;
        if(price>this.hprice)
            this.hprice = price;
        if(price<this.lprice)
            this.lprice = price;
        display();
    }
}
