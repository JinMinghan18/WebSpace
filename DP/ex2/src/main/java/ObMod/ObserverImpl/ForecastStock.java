package ObMod.ObserverImpl;

import ObMod.DisplayElement;
import ObMod.Observer;
import ObMod.SubjectImpl.StockData;
import ObMod.subject;

public class ForecastStock implements Observer, DisplayElement {
    private subject stockData;
    private double price;
    private int count = 0;
    private double avgprice;
    private String flag;
    public ForecastStock(StockData stockData){
        this.stockData = stockData;
        stockData.addObservers(this);
    }
    @Override
    public void display() {
        if(flag.equals("0"))
            System.out.println("当前股价高于均值，涨势良好，请留意短期回调");
        if(flag.equals("1"))
            System.out.println("当前股价低于均值，走势较差，请注意避险");
    }

    @Override
    public void update(double price) {
        double sum = avgprice*count+price;
        count++;
        this.avgprice = sum/count;
        if (price>avgprice)
            this.flag = "0";
        else
            this.flag = "1";
        display();
    }
}
