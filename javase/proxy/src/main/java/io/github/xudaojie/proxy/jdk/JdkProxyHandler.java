package io.github.xudaojie.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xdj
 */
public class JdkProxyHandler implements InvocationHandler {

    private Object obj;

    public JdkProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-");
        System.err.println("jdk InvocationHandler: before");
        Object result = method.invoke(obj, args);
        System.err.println("jdk InvocationHandler: after");
        System.out.println("-");
        return result;
    }

}
