package io.github.xudaojie.javase.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁测试类
 *
 * @author XuDaojie
 * @since 2021/3/21
 */
public class DeadlockTest {

    /**
     * 死锁
     *
     * 单元测试中无法复现
     * @see DeadlockDemo#main(String[])
     */
    @Test
    public void deadlockTest() {
        DeadlockDemo demo = new DeadlockDemo();
        demo.deadlock();
    }

    /**
     * 上层增加公共锁
     *
     * 单元测试中无法复现
     * @see DeadlockFix#main(String[])
     */
    @Test
    public void deadlockFixTest() {
        DeadlockFix demo = new DeadlockFix();
        demo.deadlock();
    }

    /**
     * 解除循环依赖
     *
     * 单元测试中无法复现
     * @see DeadlockFix2#main(String[])
     */
    @Test
    public void deadlockFix2Test() {
        DeadlockFix2 demo = new DeadlockFix2();
        demo.deadlock();
    }


    @Test
    public void deadlockFix3Test() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        System.out.println("延迟解除抢占");
        lock.tryLock(3, TimeUnit.SECONDS);
        System.out.println("获得锁");
        lock.unlock();

    }
}
