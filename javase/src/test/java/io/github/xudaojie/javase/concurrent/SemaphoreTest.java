package io.github.xudaojie.javase.concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author XuDaojie
 * @since 2021/5/27
 */
public class SemaphoreTest {

    @Test
    public void test() {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
    }

    class SemaphoreWorker implements Runnable {
        private String name;
        private Semaphore semaphore;

        public SemaphoreWorker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                log("is waiting for a permit!");
                semaphore.acquire();
                log("acquired a permit!");
                log("executed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log("released a permit!");
                semaphore.release();
            }
        }

        private void log(String msg) {
            if (name == null) {
                name = Thread.currentThread().getName();
            }
            System.out.println(name + " " + msg);
        }
    }
}
