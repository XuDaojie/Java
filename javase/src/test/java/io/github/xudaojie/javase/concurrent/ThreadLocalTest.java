package io.github.xudaojie.javase.concurrent;

import org.junit.Test;

public class ThreadLocalTest {

    @Test
    public void m1Test() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread t1 = new Thread(() -> {
            try {
                threadLocal.set("t1");
                threadLocal.set("t11");
                Thread.sleep(1000);
                System.out.println("t1=" + threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                threadLocal.set("t2");
                threadLocal.set("t22");
                Thread.sleep(1000);
                System.out.println("t2=" + threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        });
        t1.start();
        t2.start();
        while (true) {
        }
//        while (true) {
//            t1.start();
//            t2.start();
//        }
    }
}
