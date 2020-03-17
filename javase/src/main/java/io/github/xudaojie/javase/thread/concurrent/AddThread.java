package io.github.xudaojie.javase.thread.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xdj on 2017/5/8.
 */
public class AddThread implements Runnable {
    private static final int THREAD_POOL_SIZE = 2;

    private List<Double> list;

    public AddThread(List<Double> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; ++i) {
            list.add(Math.random());
        }
    }

    public static void test() {
        //        List<Double> list = new ArrayList<>();
        List<Double> list = new CopyOnWriteArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        es.execute(new AddThread(list));
        es.execute(new AddThread(list));
        es.shutdown();
    }
}
