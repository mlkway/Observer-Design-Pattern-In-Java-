import java.text.DecimalFormat;


public class GetTheStock implements Runnable{

    private int startTime;
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice){
        this.stockGrabber = stockGrabber;
        this.stock =  newStock;
        this.price = newPrice;
        this.startTime = newStartTime;
    }


    @Override
    public void run() {
        for (int i= 1; i <= 20; i++){


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double randNum = (Math.random() * (.06)) - .03;
            DecimalFormat df = new DecimalFormat("#.##");
            price = Double.valueOf(df.format(price + randNum));

            if (stock == "IBM") ((StockGrabber)stockGrabber).setIbmPrice(price);
            if (stock == "AAPL") ((StockGrabber)stockGrabber).setIbmPrice(price);
            if (stock == "GOOG") ((StockGrabber)stockGrabber).setIbmPrice(price);
            System.out.println(stock + ": " + df.format(price + randNum) +
                    " " + df.format(randNum));

            System.out.println();

        }
    }
}
