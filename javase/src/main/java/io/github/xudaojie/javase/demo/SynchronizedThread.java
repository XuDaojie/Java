package io.github.xudaojie.javase.demo;

/**
 * Created by xdj on 2017/5/11.
 */
public class SynchronizedThread implements Runnable {

    public static void test() {
        Runnable runnable = new SynchronizedThread();

        Thread thread1 = new Thread(runnable, "t1");
        Thread thread2 = new Thread(runnable, "t2");
//        Thread thread3 = new Thread(new SynchronizedThread(), "t3");

        thread1.start();
        thread2.start();
//        thread3.start();
    }

    private Object obj1 = new Object();
    private volatile Object obj2 = new Object();

    public synchronized void m1() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
        }
    }

    public void m2() {
//        obj1 = SynchronizedThread.class;
        synchronized (obj1) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }

    public void m3() {
        for (int i = 0; i < 100; i++) {
            System.out.println(obj2 + " " + Thread.currentThread().getName() + " synchronized loop " + i);
        }
    }

    @Override
    public void run() {
//        m1();
//        m2();
        m3();
    }
}
