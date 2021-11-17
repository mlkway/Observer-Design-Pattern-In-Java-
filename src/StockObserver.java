public class StockObserver implements Observer{

    private double ibmPrice;
    private double aaplPrice;
    private double googlPrice;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber){
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);
        stockGrabber.register(this);
    }



    @Override
    public void update(double ibmPrice, double aaplPrice, double googlPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googlPrice =  googlPrice;

        printThePrices();
    }

    private void printThePrices() {
        System.out.println(observerID + "\nIbM: " + ibmPrice +
                "\nAAPL: " + aaplPrice + "\nGOOG: " + googlPrice );
    }
}
