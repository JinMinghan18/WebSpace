package ObMod;

public interface subject {
    public void addObservers(Observer o);
    public void deleteObservers(Observer o);
    public void notifyObservers();
}
