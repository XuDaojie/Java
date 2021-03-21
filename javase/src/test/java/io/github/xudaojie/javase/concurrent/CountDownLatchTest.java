package io.github.xudaojie.javase.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    /**
     * 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
     */
    @Test
    public void worker1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(5000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("可执行其他工作");
        System.out.println("等待其他线程执行完毕");
        countDownLatch.await();

        System.out.println("任务执行完毕");
    }
}
