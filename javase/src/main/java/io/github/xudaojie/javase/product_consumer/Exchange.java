package io.github.xudaojie.javase.product_consumer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author XuDaojie
 * @since 2021/4/27
 */
public class Exchange {

    /**
     * 库存
     */
    private LinkedBlockingQueue<Bike> storage = new LinkedBlockingQueue<>();

    public void put(Bike bike) throws InterruptedException {
        this.storage.put(bike);
        System.out.println("厂商库存+1，库存：" + storage.size());
    }

    /**
     * @param count 销售数量
     */
    public Collection<Bike> take(int count) {
        int takeCount = count;
        if (this.storage.size() < 5) {
            takeCount = this.storage.size();
        }

        List<Bike> bikes = new ArrayList<>(takeCount);
        for (int i = 0; i < count; i++) {
            // 抢货 无货则为null
            Bike bike = this.storage.poll();
            if (bike == null) {
                System.out.println("厂商库存不足" + count);
                return bikes;
            }
            bikes.add(bike);
        }
        return bikes;
    }

    public static void main(String[] args) throws InterruptedException {
        Exchange exchange = new Exchange();

        BikeFactory bikeFactory = new BikeFactory(exchange);
        Shop shop1 = new Shop(exchange);
        Shop shop2 = new Shop(exchange);

        Thread tBikeFactory = new Thread(bikeFactory);
        Thread tShop1In = new Thread(shop1.getInRunnable(), "商店1");
        Thread tShop1Out = new Thread(shop1.getOutRunnable(), "商店1");
        Thread tShop2In = new Thread(shop2.getInRunnable(), "商店2");
        Thread tShop2Out = new Thread(shop2.getOutRunnable(), "商店2");

        tBikeFactory.start();
        Thread.sleep(8000);
        tShop1In.start();
        tShop2In.start();
        tShop1Out.start();
        tShop2Out.start();
    }
}
