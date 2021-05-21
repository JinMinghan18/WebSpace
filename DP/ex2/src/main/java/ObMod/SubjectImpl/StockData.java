package ObMod.SubjectImpl;
import ObMod.Observer;
import ObMod.subject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StockData implements subject{
    private ArrayList observers;
    private float price;
    private float hprice;
    private float lprice;
    public StockData(){
        observers = new ArrayList();
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
            o.update(price,hprice,lprice);
        }
    }
    public 
}
