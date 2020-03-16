package io.github.xudaojie.javase.classloader;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest {

    @Test
    public void classLoaderTreeTest() {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
        loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader.toString());
    }

    @Test
    public void m1Test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        Sample c1 = (Sample) loader.loadClass("io.github.xudaojie.javase.classloader.Sample").newInstance();
        Sample c2 = (Sample) loader.loadClass("io.github.xudaojie.javase.classloader.Sample").newInstance();
        System.out.println(c1);
        System.out.println(c2);

    }

    @Test
    public void m2Test() throws MalformedURLException, ClassNotFoundException {
        URLClassLoader loader = URLClassLoader.newInstance(new URL[] {new URL("file://Users/xdj/IdeaProjects/Java/javase/out/production/classes/io/github/xudaojie/javase/classloader")});
        Class c1 = loader.loadClass("Sample");
        Class c2 = loader.loadClass("Sample");
        System.out.println(c1);
        System.out.println(c2);
    }

    
}