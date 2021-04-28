package io.github.xudaojie.javase.concurrent;

/**
 * 解除锁循环依赖
 *
 * @author XuDaojie
 * @since 2021/3/21
 */
public class DeadlockFix2 {

    public void method1(String tName) {
        synchronized (String.class) {
            System.out.println(tName + ": Acquired lock on String.class object");
            synchronized (Integer.class) {
                System.out.println(tName + ": Acquired lock on Integer.class object");
            }
        }
    }

    public void method2(String tName) {
        synchronized (String.class) {
            System.out.println(tName + ": Acquired lock on String.class object");
            synchronized (Integer.class) {
                System.out.println(tName + ": Acquired lock on Integer.class object");
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
        DeadlockFix2 demo = new DeadlockFix2();
        demo.deadlock();
    }
}
