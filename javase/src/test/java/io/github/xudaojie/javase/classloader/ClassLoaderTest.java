package io.github.xudaojie.javase.classloader;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.MessageFormat;

import io.github.xudaojie.javase.cl.Data;
import io.github.xudaojie.javase.cl.IFac;

public class ClassLoaderTest {

    /**
     * 打印当前classloader父类
     */
    @Test
    public void classLoaderTreeTest() {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        // 打印当前类加载器，直到最上层ClassLoader
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }

        loader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前线程ClassLoader： " + loader.toString());
    }

    /**
     * 创建实例
     */
    @Test
    public void loadClassTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        Sample c1 = (Sample) loader.loadClass("io.github.xudaojie.javase.classloader.Sample").newInstance();
        Sample c2 = (Sample) loader.loadClass("io.github.xudaojie.javase.classloader.Sample").newInstance();
        System.out.println(c1);
        System.out.println(c2);

    }

    /**
     * 加载外部class
     */
    @Test
    public void loadClassForFileTest() throws MalformedURLException, ClassNotFoundException {
        String userDir = System.getProperty("user.dir");
        URLClassLoader loader = URLClassLoader.newInstance(new URL[] {
//            new URL(MessageFormat.format("file:/{0}/out/production/classes/io/github/xudaojie/javase/classloader/", userDir))
            new URL(MessageFormat.format("file:/{0}/out/production/classes", userDir))
        });
        Class c1 = loader.loadClass("io.github.xudaojie.javase.classloader.Sample");
        Class c2 = loader.loadClass("io.github.xudaojie.javase.classloader.Sample");
        System.out.println(c1);
        System.out.println(c2);
    }

    /**
     *
     */
    @Test
    public void linkageErrorTest() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String userDir = System.getProperty("user.dir");
        // 需要先编译
//        URLClassLoader loader1 = URLClassLoader.newInstance(new URL[] {
//            //
////            new URL(MessageFormat.format("file:///Users/xdj/IdeaProjects/Java/javase/classloader_1/out/production/classes/io/github/xudaojie/javase/cl/", userDir))
//            new URL(MessageFormat.format("file:///Users/xdj/IdeaProjects/Java/javase/classloader_1/out/production/classes/io/github/xudaojie/javase/cl/", userDir))
//        });
//        URLClassLoader loader2 = URLClassLoader.newInstance(new URL[] {
//
//            new URL(MessageFormat.format("file:/{0}/classloader_1/out/production/classesCopy", userDir))
//        });
        URLClassLoader loader1 = new MyURLClassLoader(new URL[]{
            // 文件夹必须以 / 结尾，否则被识别为jar包
            new URL(MessageFormat.format("file:///Users/xdj/IdeaProjects/Java/javase/classloader_1/out/production/classes/", userDir))
        });
        URLClassLoader loader2 = new MyURLClassLoader(new URL[]{
            // 文件夹必须以 / 结尾，否则被识别为jar包
            new URL(MessageFormat.format("file:///Users/xdj/IdeaProjects/Java/javase/classloader_1/out/production/classes/", userDir))
        });

        Class class1 = loader1.loadClass("io.github.xudaojie.javase.cl.Data");
        Class class1_2 = loader2.loadClass("io.github.xudaojie.javase.cl.Data");
//        Class class2 = loader2.loadClass("io.github.xudaojie.javase.cl.Data");
//        Class class3 = this.getClass().getClassLoader().loadClass("io.github.xudaojie.javase.cl.Data");

        System.out.println(class1.equals(class1_2));
//        System.out.println(data1);
//        System.out.println(data2);
//        System.out.println(data1.getClass() == data2.getClass());
//        System.out.println(data1.getClass() == data3.getClass());
    }

    @Test
    public void linkageError2Test() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Data resolved = new Data();
        MyURLClassLoader myURLClassLoader = new MyURLClassLoader(new URL[]{
            // 文件夹必须以 / 结尾，否则被识别为jar包
            new URL("file:///Users/xdj/IdeaProjects/Java/javase/classloader_2/build/libs/classloader_2.jar"),
            new URL("file:///Users/xdj/IdeaProjects/Java/javase/classloader_2/build/libs/classloader_data.jar")
        });
        IFac fac = (IFac) myURLClassLoader.loadClass("io.github.xudaojie.javase.cl.FacImpl").newInstance();
        Data data = fac.getData();

    }
}