public class GrabStocks {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setAaplPrice(198.00);
        stockGrabber.setGooglPrice(199.00);

        StockObserver observer2 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(300.00);
        stockGrabber.setAaplPrice(301.00);
        stockGrabber.setGooglPrice(302.00);

        stockGrabber.unregister(observer1);


        stockGrabber.setIbmPrice(300.00);
        stockGrabber.setAaplPrice(301.00);
        stockGrabber.setGooglPrice(302.00);

        Runnable getIbm = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
        Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.00);
        Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.00);

        new Thread(getAAPL);
        new Thread(getIbm);
        new Thread(getGOOG);





    }


}
