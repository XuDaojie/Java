package io.github.xudaojie.javase.thread;

import java.util.concurrent.Executors;

/**
 * @author xdj
 * @since 2020/7/19
 */
public class ExecutorsTest {

    @org.junit.Test
    public void m1() {
        // 可延期或定时执行任务的线程池
        Executors.newScheduledThreadPool(10);
        // 固定线程数线程池
        Executors.newFixedThreadPool(10);
        // 可缓存的线程池，可灵活回收空闲进行
        Executors.newCachedThreadPool();
        // 单线程线程池
        Executors.newSingleThreadExecutor();
        // 单线程可延期执行的线程池
        Executors.newSingleThreadScheduledExecutor();
        // 具有抢占式操作的线程池 @since 1.8
        Executors.newWorkStealingPool(4);
    }
}
