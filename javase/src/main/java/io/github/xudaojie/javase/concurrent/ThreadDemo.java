package io.github.xudaojie.javase.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author XuDaojie
 * @since 2021/6/2
 */
public class ThreadDemo {

    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("12311");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        System.out.println("123");
//        Thread.interrupted();
//
//        System.out.println("123");
        System.out.println("123");
        LockSupport.park();

                System.out.println("123");
    }
}
