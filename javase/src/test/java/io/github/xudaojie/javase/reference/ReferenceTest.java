package io.github.xudaojie.javase.reference;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Date;

public class ReferenceTest {

    /**
     * 软引用
     */
    @Test
    public void softReferenceTest() {
        // 强引用
        String strongReference = new String("abc");
        // 软引用
        String str = new String("abc");
        SoftReference<String> softReference = new SoftReference<String>(str);
//        getClass().getName() + "@" + Integer.toHexString(hashCode());
        System.out.println("@" + Integer.toHexString(strongReference.hashCode()));
        System.out.println("@" + Integer.toHexString(str.hashCode()));
        System.out.println(softReference);
    }

    /**
     * 软引用2
     * ReferenceQueue
     */
    @Test
    public void softReference2Test() {
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String str = new String("abc");
        SoftReference<String> softReference = new SoftReference<>(str, referenceQueue);

        System.out.println("@" + Integer.toHexString(System.identityHashCode(str)));
        System.out.println("@" + Integer.toHexString(System.identityHashCode(softReference)));
        System.out.println("@" + Integer.toHexString(System.identityHashCode(softReference.get())));

        str = null;
        // Notify GC
        System.gc();

        System.out.println(softReference.get()); // abc

        Reference<? extends String> reference = referenceQueue.poll();
        System.out.println(reference); // null
    }

    /**
     * 弱引用
     */
    @Test
    public void weekReferenceTest() {
        String str = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(str);
        str = null;
        System.out.println("weak:" + weakReference.get()); // abc
        System.gc();
        System.out.println("weak:" + weakReference.get()); // null
    }

    /**
     * 虚引用(PhantomReference)
     */
    @Test
    public void phantomReferenceTest() {
        String str = new String("abc");
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        // 创建虚引用，要求必须与一个引用队列关联
        PhantomReference<String> pr = new PhantomReference<>(str, queue);
        System.out.println(pr.get());
    }

    /**
     * 虚引用2
     */
    @Test
    public void phantomReference2Test() throws InterruptedException {
        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Date> phantomReference = new PhantomReference<>(date, referenceQueue);

        System.out.println("虚引用：" + phantomReference);
        System.out.println("引用对象：@" + Integer.toHexString(System.identityHashCode(date)));

        new Thread() {
            @Override
            public void run() {
//                super.run();
                try {
                    Reference reference = referenceQueue.remove();
                    System.out.println("虚引用被回收:" + reference + "; isEnqueued: " + reference.isEnqueued());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        date = null;

        while (true) {
            System.out.println("System.gc();");
            System.gc();
            Thread.sleep(1000);
        }

    }

    /**
     * https://blog.csdn.net/aitangyong/article/details/39453365
     *
     * 当GC一但发现了虚引用对象，将会将PhantomReference对象插入ReferenceQueue队列.
     * 而此时PhantomReference所指向的对象并没有被GC回收，而是要等到ReferenceQueue被你真正的处理后才会被回收.
     *
     * <pre>
     * 不发生GC执行结果是:
     * null
     * null
     * null
     * null
     *
     * 发生GC执行结果是:
     * null
     * null
     * null
     * java.lang.ref.PhantomReference@87816d
     * </pre>
     * <p>
     * 虚引用在实现一个对象被回收之前必须做清理操作是很有用的,比finalize()方法更灵活
     */
    @Test
    public void phantomTest() throws Exception {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> phantom = new PhantomReference<Object>(obj,
            refQueue);
        System.out.println(phantom.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null

        obj = null;
        System.gc();

        // 调用phanRef.get()不管在什么情况下会一直返回null
        System.out.println(phantom.get());

        // 当GC发现了虚引用，GC会将phanRef插入进我们之前创建时传入的refQueue队列
        // 注意，此时phanRef所引用的obj对象，并没有被GC回收，在我们显式地调用refQueue.poll返回phanRef之后
        // 当GC第二次发现虚引用，而此时JVM将phanRef插入到refQueue会插入失败，此时GC才会对obj进行回收
        Thread.sleep(200);
        System.out.println(refQueue.poll());
    }
}
