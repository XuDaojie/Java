package io.github.xudaojie.javase.xx;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

/**
 * @author XuDaojie
 * @since 2021/4/27
 */
public class Shop {

    private static final Random random = new Random(System.currentTimeMillis());

    private Exchange exchange;
    private LinkedList<Bike> storage = new LinkedList<>();

    private Runnable inRunnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                in();
            }
        }
    };
    private Runnable outRunnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                int timeout = (random.nextInt(10) + 1) * 1000;
                try {
                    System.out.println(Thread.currentThread().getName() + "准备卖出商品--时间间隔： " + timeout + "ms");
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out();
            }
        }
    };

    public Shop(Exchange exchange) {
        this.exchange = exchange;
    }

    public Runnable getInRunnable() {
        return inRunnable;
    }

    public Runnable getOutRunnable() {
        return outRunnable;
    }

    /**
     * 进货
     */
    public synchronized void in() {
        int tmpStorageCnt = this.storage.size();
        Collection<Bike> bikes = exchange.take(5);
        this.storage.addAll(bikes);
        System.out.println(Thread.currentThread().getName() + "进货数量: " + bikes.size() + " 库存：" + this.storage.size());
        if (tmpStorageCnt == 0 && this.storage.size() > 0) {
            notify();
            System.err.println(Thread.currentThread().getName() + "恢复销售");
        }
    }

    /**
     * 出货
     */
    public synchronized void out() {
        if (storage.size() == 0) {
            try {
                System.err.println(Thread.currentThread().getName() + "库存为0，停止销售");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        storage.poll();
        System.out.println(Thread.currentThread().getName() + "卖出1辆单车 库存：" + storage.size());
    }

}
