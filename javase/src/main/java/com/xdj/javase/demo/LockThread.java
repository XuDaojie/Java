package com.xdj.javase.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xdj on 2017/5/11.
 */
public class LockThread {
    public static void test() {
        Lock lock = new ReentrantLock();
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
//            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
