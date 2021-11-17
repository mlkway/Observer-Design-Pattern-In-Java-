import java.util.ArrayList;

public class StockGrabber implements Subject{

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googlPrice;

    public StockGrabber(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        System.out.println("Observer " + observers.indexOf(o) + " deleted");
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers){
            observer.update(ibmPrice,aaplPrice,googlPrice);
        }
    }



    public void setIbmPrice(double price){
        this.ibmPrice = price;
        notifyObserver();
    }
    public void setAaplPrice(double price){
        this.aaplPrice = price;
        notifyObserver();
    }
    public void setGooglPrice(double price){
        this.googlPrice = price;
        notifyObserver();
    }

}
