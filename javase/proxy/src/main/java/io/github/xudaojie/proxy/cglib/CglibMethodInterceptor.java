package io.github.xudaojie.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xdj
 */
public class CglibMethodInterceptor implements MethodInterceptor {

    /**
     * @param obj cglib生成的代理对象
     * @param method 被代理对象方法
     * @param args ignore
     * @param proxy 代理方法
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("-");
        System.err.println("cglib MethodInterceptor: before");
        Object result = proxy.invokeSuper(obj, args);
        System.err.println("cglib MethodInterceptor: after");
        System.out.println("-");
        return result;
    }
}
