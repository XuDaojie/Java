package io.github.xudaojie.javase.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    /**
     * 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
     *
     * worker1 线程任务执行完毕后才继续执行 main 线程任务
     *
     * +--------------------------------------------------------------------------------------+
     * |   worker:    worker.start()         --------------------> countDownLatch.countDown() |
     * |   main:      countDownLatch.await() --------------------> downSomething()            |
     * |                           lock，直到worker线程执行完毕并将CountDownLatch的值变为0        |
     * +--------------------------------------------------------------------------------------+
     */
    @Test
    public void worker1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        new Thread("worker") {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + " 任务执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("可执行其他工作");
        System.out.println("等待 worker 线程执行完毕");
        latch.await();

        System.out.println(Thread.currentThread().getName() + " 任务执行完毕");
    }
}
