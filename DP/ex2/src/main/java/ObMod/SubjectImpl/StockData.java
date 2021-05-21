package ObMod.SubjectImpl;
import ObMod.Observer;
import ObMod.subject;

import java.util.ArrayList;


public class StockData implements subject{
    private ArrayList observers;
    private double price;
    public StockData(){
        observers = new ArrayList<Observer>();
    }
    @Override
    public void addObservers(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObservers(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++){
            Observer o = (Observer) observers.get(i);
            o.update(price);
        }
    }

    @Override
    public void StockInfoChanged() {
        notifyObservers();
    }
    public void setStockInfo(double nowprice){
        this.price = nowprice;
        StockInfoChanged();
    }
}
