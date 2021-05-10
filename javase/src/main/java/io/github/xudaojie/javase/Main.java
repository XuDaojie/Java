package io.github.xudaojie.javase;

import java.net.MalformedURLException;

/**
 * Created by xdj on 2017/5/8.
 */
public class Main {

//    private static final Long[] l1 = new Long[Integer.MAX_VALUE / 2];
//    private static final Long[] l2 = new Long[Integer.MAX_VALUE / 2];
//    private static final Long[] l3 = new Long[Integer.MAX_VALUE / 2];
//    private static final Long[] l4 = new Long[Integer.MAX_VALUE / 2];
//    private static final Long[] l5 = new Long[Integer.MAX_VALUE / 2];
//    private static final Long[] l6 = new Long[Integer.MAX_VALUE / 2];
//    private static final Long[] l7 = new Long[Integer.MAX_VALUE / 2];

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//        AddThread.test();

//        try {
//            ThreadDeadlock.test();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        SynchronizedThread.test();

//        VolatileDemo.test();
//        System.out.println("sss");

        // 包含ifac、data
//        Data resolved = new Data();
//        MyURLClassLoader myURLClassLoader = new MyURLClassLoader(new URL[]{
//            // 文件夹必须以 / 结尾，否则被识别为jar包
//            new URL("file:///Users/xdj/IdeaProjects/Java/javase/classloader_impl/build/libs/classloader_impl.jar"), // ifac
//            new URL("file:///Users/xdj/IdeaProjects/Java/javase/classloader_data/build/libs/classloader_data.jar") // data
//        });
//        IFac fac = (IFac) myURLClassLoader.loadClass("io.github.xudaojie.javase.cl.FacImpl").newInstance();
//        fac.getData();

//        stopwatch.start();
        long num = 1;
//        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 10; i++) {
            num = num * 2;
        }
//        System.out.println(num);
//        System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));

        num = 1;
//        stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 10; i++) {
            num = num << 1;
        }
//        System.out.println(num);
//        System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));



    }

}
