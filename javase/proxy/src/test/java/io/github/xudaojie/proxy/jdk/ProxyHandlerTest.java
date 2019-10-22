package io.github.xudaojie.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

import io.github.xudaojie.proxy.UserService;
import io.github.xudaojie.proxy.UserServiceImpl;

public class ProxyHandlerTest {

    @Test
    public void proxy() {
        UserService userService = new UserServiceImpl();
        JdkProxyHandler proxyHandler = new JdkProxyHandler(userService);
        UserService proxy = (UserService) Proxy.newProxyInstance(
            UserService.class.getClassLoader(), new Class[] {UserService.class}, proxyHandler);
        proxy.login();
        System.err.println("------------------------------------");
        proxy.logout();
    }
}