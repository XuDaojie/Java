package io.github.xudaojie.javase.classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * 不遵守parent Delegate的ClassLoader
 *
 * @author XuDaojie
 * @since 2020/9/27
 */
public class MyURLClassLoader extends URLClassLoader {
    public MyURLClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public MyURLClassLoader(URL[] urls) {
        super(urls);
    }

    public MyURLClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        try {
            return findClass(name);
        } catch (ClassNotFoundException ex) {
            return super.loadClass(name, resolve);
        }

//        return super.loadClass(name, resolve);
    }

    public static URLClassLoader newInstance(final URL[] urls) {
        return new MyURLClassLoader(urls);
    }
}
