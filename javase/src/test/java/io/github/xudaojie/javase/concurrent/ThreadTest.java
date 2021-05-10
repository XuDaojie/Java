package io.github.xudaojie.javase.concurrent;

import org.junit.Test;

/**
 * @author XuDaojie
 * @since 2021/5/6
 */
public class ThreadTest {

    /**
     * 一个线程start()两次
     */
    @Test
    public void twoStartTest() {
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("run");
            }
        };
        t.start();
        t.start();

    }
}
