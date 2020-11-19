package io.github.xudaojie.javase.thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * {@link CyclicBarrier} 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。
 *
 * @author XuDaojie
 * @since 2020/9/1
 */
public class CyclicBarrierTest {

    @Test
    public void basicTest() {
        int tc = Runtime.getRuntime().availableProcessors();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(tc, new Runnable() {
            @Override
            public void run() {
                // worker 线程执行完tc次后会执行此任务
                System.out.println("timestamp:" + System.currentTimeMillis() + "-- cyclicBarrier");
            }
        });

        for (int i = 0; i < tc; i++) {

            Runnable worker = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("timestamp:" + System.currentTimeMillis() + "--" + Thread.currentThread().getName());
                        Random random = new Random();
                        try {
                            Thread.sleep(random.nextInt(10));
                            cyclicBarrier.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            new Thread(worker).start();
        }

        // 单元测试中会关闭非守护线程
//        while (true) {}
    }
}
