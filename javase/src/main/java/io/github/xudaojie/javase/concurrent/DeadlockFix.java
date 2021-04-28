package io.github.xudaojie.javase.concurrent;

/**
 * 上层增加公共锁
 *
 * @author XuDaojie
 * @since 2021/3/21
 */
public class DeadlockFix {

    public void method1(String tName) {
        synchronized (Long.class) {
            synchronized (String.class) {
                System.out.println(tName + ": Acquired lock on String.class object");
                synchronized (Integer.class) {
                    System.out.println(tName + ": Acquired lock on Integer.class object");
                }
            }
        }
    }

    public void method2(String tName) {
        synchronized (Long.class) {
            synchronized (Integer.class) {
                System.out.println(tName + ": Acquired lock on Integer.class object");
                synchronized (String.class) {
                    System.out.println(tName + ": Acquired lock on String.class object");
                }
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
        DeadlockFix demo = new DeadlockFix();
        demo.deadlock();
    }
}
