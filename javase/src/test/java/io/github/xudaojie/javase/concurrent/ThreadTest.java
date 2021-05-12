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

    /**
     * Thread#join() 主线程等待子线程执行完毕，只有子线程执行完了才能继续执行主线程下面的代码
     */
    @Test
    public void joinTest() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("run");
            }
        };
        t.start();
        t.join(); // 阻塞，等待子线程执行完毕
        System.out.println("main");
    }

}
