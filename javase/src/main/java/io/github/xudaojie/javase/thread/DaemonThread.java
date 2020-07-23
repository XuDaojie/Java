package io.github.xudaojie.javase.thread;

/**
 * 守护线程
 * 当主线程任务执行完毕，并且剩下的所有线程都为守护线程时，守护线程会停止运行
 *
 * @author XuDaojie
 * @since 2020/7/23
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //
                int i = Thread.currentThread().isDaemon() ? Integer.MAX_VALUE : 5;
                while (--i >= 0) {
                    Thread currentThread = Thread.currentThread();
                    String msg = String.format("%s; isDeamon: %s; %s",
                        currentThread.getName(), currentThread.isDaemon(), i);
                    System.out.println(msg);
                }
            }
        };

        Runnable daemonRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": 守护线程中执行子线程");
                Thread daemonThread = ThreadFactory.newDaemonThread(runnable);
                daemonThread.start();
            }
        };

        Thread daemonThread = ThreadFactory.newDaemonThread(daemonRunnable);
        Thread basicThread = ThreadFactory.newThread(runnable);

        daemonThread.start();
        basicThread.start();

        System.out.println("主线程");
    }

    static class ThreadFactory {

        public static Thread newThread(Runnable runnable) {
            Thread t = new Thread(runnable);
            return t;
        }

        public static Thread newDaemonThread(Runnable runnable) {
            Thread t = newThread(runnable);
            t.setDaemon(true);
            return t;
        }
    }
}
