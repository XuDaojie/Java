package io.github.xudaojie.javase.product_consumer;

/**
 * @author XuDaojie
 * @since 2021/4/27
 */
public class BikeFactory implements Runnable {

    private Exchange exchange;

    public BikeFactory(Exchange exchange) {
        this.exchange = exchange;
    }

    /**
     * 生产
     */
    public void product() {
        try {
            Thread.sleep(2000);
            exchange.put(new Bike());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product();
        }
    }

}
