package io.github.xudaojie.javase.concurrent;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author XuDaojie
 * @since 2021/4/28
 */
public class ReentrantLockTest {

    /**
     * 由于await依赖synchronized
     * ReentrantLock 使用Condition替换await方法
     */
    @Test
    public void awaitTest() {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
    }
}
