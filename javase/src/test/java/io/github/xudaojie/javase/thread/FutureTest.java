package io.github.xudaojie.javase.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Supplier;

public class FutureTest {

    @Test
    public void futureTest() throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "HelloWorld";
            }
        });

        // 等执行完毕后返回
        String str = future.get();
        System.out.println("future.get() = " + str);
    }

    @Test
    public void CompletableFutureTest() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + " HelloWorld");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "HelloWorld";
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + " 翻过长城");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "翻过长城";
            }
        });

        // 等执行完毕后返回
        String str1 = future1.get();
        System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + " future1.get() = " + str1);
        String str2 = future2.get();
        System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + " future2.get() = " + str2);
    }

    @Test
    public void CompletableFuture2Test() throws InterruptedException, ExecutionException {
        // 默认线程池
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(System.currentTimeMillis() + " HelloWorld");

                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "HelloWorld";
            }
        });

        // 自定义线程池
        ExecutorService pool = Executors.newFixedThreadPool(4);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(System.currentTimeMillis() + " 翻过长城");

                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "翻过长城";
            }
        }, pool);

        // 链式执行
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(System.currentTimeMillis() + " Hello World!");

                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello World!";
            }
        }).thenApply(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println(System.currentTimeMillis() + " thenApply");
                return s + " thenApply";
            }
        });

        // 等执行完毕后返回
        String str1 = future1.get();
        System.out.println(System.currentTimeMillis() + " future1.get() = " + str1);
        String str2 = future2.get();
        System.out.println(System.currentTimeMillis() + " future2.get() = " + str2);
        String str3 = future3.get();
        System.out.println(System.currentTimeMillis() + " future3.get() = " + str3);
    }
}
