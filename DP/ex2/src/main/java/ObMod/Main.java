package ObMod;

import ObMod.ObserverImpl.CurrentStock;
import ObMod.ObserverImpl.ForecastStock;
import ObMod.ObserverImpl.StatisticStock;
import ObMod.SubjectImpl.StockData;

import java.util.Random;

public class Main {
    public static double random(){
        final Random random = new Random();
        int x;
        double mm = 0;
        for(int i=0;i<10;i++) {
            mm=random.nextFloat()*100; //浮点数
            x=random.nextInt(50);           //整数
        }
        return mm;
    }
    public static void main(String[] args) {
        double price = random();
        StockData stockData = new StockData();

        CurrentStock currentStock = new CurrentStock(stockData);
        StatisticStock statisticStock = new StatisticStock(stockData);
        ForecastStock forecastStock = new ForecastStock(stockData);

        stockData.setStockInfo(price);
        price = random();
        stockData.setStockInfo(price);
        price = random();
        stockData.setStockInfo(price);

    }

}
