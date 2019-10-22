package com.ald.news.user.controller.api;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by xuxm on 2018/7/23
 */
public class UserLevelControllerTest {

    @Test
    public void listActiveLevels() {
        concurrenceTest();
    }

    public static void test1() throws IOException {
        System.out.println("===>>" + UUID.randomUUID().toString());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8680/staticComment/reply?userId=117838&type=dynamic&pageNum=1&pageSize=10")
                .get()
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "36f707e3-b104-4228-b120-c1583cd00c8f")
                .build();
        Response response = client.newCall(request).execute();
    }

    public static void concurrenceTest() {
        /**
         * 模拟高并发情况代码
         */
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1000); // 相当于计数器，当所有都准备好了，再一起执行，模仿多并发，保证并发量
        final CountDownLatch countDownLatch2 = new CountDownLatch(1000); // 保证所有线程执行完了再打印atomicInteger的值
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            for (int i = 0; i < 1000; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            countDownLatch.await(); //一直阻塞当前线程，直到计时器的值为0,保证同时并发
                            test1();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //每个线程增加1000次，每次加1
                        for (int j = 0; j < 10; j++) {
                            atomicInteger.incrementAndGet();
                        }
                        countDownLatch2.countDown();
                    }
                });
                countDownLatch.countDown();
            }
            countDownLatch2.await();// 保证所有线程执行完
            System.out.println(atomicInteger);
            executorService.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}