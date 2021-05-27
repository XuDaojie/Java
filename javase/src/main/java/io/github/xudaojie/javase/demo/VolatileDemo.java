package io.github.xudaojie.javase.demo;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xdj on 2017/5/15.
 */
public class VolatileDemo {
    public static int count = 0;
    public static AtomicInteger atomicCount = new AtomicInteger(0);

    public static volatile  int V_COUNT = 0;

    public static void test() {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    synchronized (VolatileDemo.class) {
                    VolatileDemo.count++;
                    System.out.println(VolatileDemo.count);
//                    }
                }
            }).start();
        }

        try {
            // 确保子线程全部执行完毕
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结果:Counter.count=" + VolatileDemo.count);
    }

    public static void test2() {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    lock.lock();
                    VolatileDemo.count++;
                    System.out.println(VolatileDemo.count);
                    lock.unlock();
                }
            }).start();
        }

        try {
            // 确保子线程全部执行完毕
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结果:Counter.count=" + VolatileDemo.count);
    }

    public static void test3() {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    VolatileDemo.atomicCount.incrementAndGet();
                    System.out.println(VolatileDemo.atomicCount);
                }
            }).start();
        }

        try {
            // 确保子线程全部执行完毕
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结果:Counter.count=" + VolatileDemo.atomicCount);
    }

    /**
     * 测试volatile和不加volatile性能差距
     */
    public static void test4() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            V_COUNT++;
        }
        System.out.println(V_COUNT + " " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
        System.out.println(count + " " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args) {
        test4();
    }
}
