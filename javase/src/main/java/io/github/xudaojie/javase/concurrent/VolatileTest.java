package io.github.xudaojie.javase.concurrent;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XuDaojie
 * @since 2021/6/17
 */
public class VolatileTest {

    private volatile int i = 0;

    /**
     * 线程安全测试
     */
    public void syncSafeTest() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int count = 0; count < 1000000; count++) {
                    i++;
                    System.out.println(i);
                }

            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileT = new VolatileTest();
        volatileT.syncSafeTest();
    }

    /**
     * Created by xdj on 2017/5/15.
     */
    public static class VolatileDemo {
        public static int count = 0;
        public static AtomicInteger atomicCount = new AtomicInteger(0);

        public static volatile int V_COUNT = 0;

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
//                        System.out.println(VolatileDemo.count);
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

        /**
         * 使用ReentrantLock 确保线程安全
         */
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

        /**
         * 使用原子类
         */
        public static void test3() {
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
//            test1();
//            test2();
//            test3();
            test4();
        }
    }
}
