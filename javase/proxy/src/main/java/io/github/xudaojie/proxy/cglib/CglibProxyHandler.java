package io.github.xudaojie.proxy.cglib;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author xdj
 */
public class CglibProxyHandler implements InvocationHandler {

    private Object obj;

    public CglibProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-");
        System.err.println("cglib InvocationHandler: before");
        Object result = method.invoke(obj, args);
        System.err.println("cglib InvocationHandler: after");
        System.out.println("-");
        return result;
    }
}
