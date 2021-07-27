package io.github.xudaojie.javase.concurrent;

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

    /**
     * 所有worker 线程完成睡眠后才会继续执行主线程
     * @throws InterruptedException ignore
     */
    @Test
    public void basicTest() throws InterruptedException {
        int tc = Runtime.getRuntime().availableProcessors();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(tc, new Runnable() {
            @Override
            public void run() {
                // worker 线程执行完tc次后会执行此任务
                System.out.println("timestamp:" + System.currentTimeMillis() + " -------------------- cyclicBarrier");
            }
        });

        for (int i = 0; i < tc; i++) {

            Runnable worker = new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int sleepMillis = random.nextInt(2000);
                    System.out.println("tag::sleep " + sleepMillis + " timestamp:" + System.currentTimeMillis() + "--" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(sleepMillis);
                        cyclicBarrier.await(); // Barrier
                        System.out.println("end::sleep " + sleepMillis + " timestamp:" + System.currentTimeMillis() + "--" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(worker).start();
        }

        // 单元测试执行完后会调用System.exit();
        // 防止线程还没执行完毕，主线程就被关闭
        Thread.sleep(3000);
        System.out.println("-------------------------------------------------");
        System.out.println("run other");
    }
}
