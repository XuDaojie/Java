package io.github.xudaojie.javase.concurrent;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XuDaojie
 * @since 2021/4/28
 */
public class ReentrantLockTest {

    /**
     *
     *
     * 由于await依赖synchronized
     * ReentrantLock 使用Condition替换await方法
     */
    @Test
    public void basicTest() throws InterruptedException {
        Counter counter1 = new Counter();
        for (int i = 0; i < 10; i++) {
            new Thread("不加锁worker" + i) {
                @Override
                public void run() {
                    counter1.increment();
                }
            }.start();
        }

        ReentrantLock lock = new ReentrantLock();
        Counter counter2 = new Counter();
        for (int i = 0; i < 10; i++) {
            new Thread("加锁worker" + i) {
                @Override
                public void run() {
                    lock.lock();
                    counter2.increment();
                    lock.unlock();
                }
            }.start();
        }
        Thread.sleep(10);
    }

    static class Counter {
        private int count;

        private void increment() {
            System.out.println(String.format(Thread.currentThread() + " count.increment()=%d", count++));
//            return count++;
        }
    }
}
