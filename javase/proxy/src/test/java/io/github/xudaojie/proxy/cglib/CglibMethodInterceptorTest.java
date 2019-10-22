package io.github.xudaojie.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

import org.junit.Test;

import io.github.xudaojie.proxy.UserService;
import io.github.xudaojie.proxy.UserServiceImpl;

public class CglibMethodInterceptorTest {

    @Test
    public void intercept() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new CglibMethodInterceptor());
        UserService proxy = (UserService) enhancer.create();
        proxy.login();
        proxy.logout();
    }
}