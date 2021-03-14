package io.github.xudaojie.javase.classloader;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.MessageFormat;

import io.github.xudaojie.javase.cl.Data;
import io.github.xudaojie.javase.cl.IFac;
import sun.misc.Launcher;
import sun.misc.URLClassPath;

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

        // 打印使用BootstrapClassLoader加载的jar包
        URLClassPath urlClassPath = Launcher.getBootstrapClassPath();
        for (URL url : urlClassPath.getURLs()) {
            System.out.println(url);
        }

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

        System.out.println(c1.getClass() == c2.getClass());

    }

    /**
     * 加载外部class xxxxx
     */
    @Test
    public void loadClassForFileTest() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String userDir = System.getProperty("user.dir");
        URLClassLoader loader1 = URLClassLoader.newInstance(new URL[] {
//            new URL(MessageFormat.format("file:/{0}/out/production/classes/io/github/xudaojie/javase/classloader/", userDir))
            new URL(MessageFormat.format("file:/{0}/out/production/classes", userDir))
        });
        Sample c1 = (Sample) loader1.loadClass("io.github.xudaojie.javase.classloader.Sample").newInstance();
        System.out.println(c1);
    }

    /**
     * 抛出LinkageError
     */
    @Test
    public void linkageError2Test() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);

        // class在使用时才会加载，使AppClassLoader加载Data类
        Data resolved = new Data();
        MyURLClassLoader myURLClassLoader = new MyURLClassLoader(new URL[]{
            // 文件夹必须以 / 结尾，否则被识别为jar包
            new URL(MessageFormat.format("file://{0}/classloader_impl/build/libs/classloader_impl.jar", userDir)),
            new URL(MessageFormat.format("file://{0}/classloader_data/build/libs/classloader_data.jar", userDir))
        });

        IFac fac = (IFac) myURLClassLoader.loadClass("io.github.xudaojie.javase.cl.FacImpl").newInstance();
        // 左边Data类为AppClassLoader加载，而右边为MyURLClassLoader 加载抛出异常
        Data data = fac.getData();
    }

    /**
     * ?????????????
     */
    @Test
    public void classLoaderTest() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String userDir = System.getProperty("user.dir");
        // 需要先编译
        URLClassLoader loader1 = new MyURLClassLoader(new URL[]{
            // 文件夹必须以 / 结尾，否则被识别为jar包
            new URL(MessageFormat.format("file://{0}/classloader_data/build/classes/", userDir))
        });
        ClassLoader loader2 = ClassLoaderTest.class.getClassLoader();

//        Class class1 = loader1.loadClass("io.github.xudaojie.javase.cl.Data");
//        Class class1_2 = loader2.loadClass("io.github.xudaojie.javase.cl.Data");

        Data class1 = (Data) loader1.loadClass("io.github.xudaojie.javase.cl.Data").newInstance();
        Data class1_2 = (Data) loader2.loadClass("io.github.xudaojie.javase.cl.Data").newInstance();

        System.out.println(class1.equals(class1_2));
        System.out.println(class1 == class1_2);
    }
}