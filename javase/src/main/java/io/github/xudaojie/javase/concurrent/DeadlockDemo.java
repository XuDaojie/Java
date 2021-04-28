package io.github.xudaojie.javase.concurrent;

/**
 * @author XuDaojie
 * @since 2021/3/21
 */
public class DeadlockDemo {
    /*
     * This method request two locks, first String and then Integer
     */
    public void method1(String tName) {
        synchronized (String.class) {
            System.out.println(tName + ": Acquired lock on String.class object");
            synchronized (Integer.class) {
                System.out.println(tName + ": Acquired lock on Integer.class object");
            }
        }
    }

    /*
     * This method also requests same two lock but in exactly Opposite order
     * i.e. first Integer and then String. This creates potential deadlock, if
     * one thread holds String lock and other holds Integer lock and they wait
     * for each other, forever.
     */

    public void method2(String tName) {
        synchronized (Integer.class) {
            System.out.println(tName + ": Acquired lock on Integer.class object");
            synchronized (String.class) {
                System.out.println(tName + ": Acquired lock on String.class object");
            }
        }
    }

    /**
     * 触发死锁
     */
    public void deadlock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    method1("t1");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    method2("t2");
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        //
        DeadlockDemo demo = new DeadlockDemo();
        demo.deadlock();
    }
}
