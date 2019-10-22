package io.github.xudaojie.proxy.cglib;

import net.sf.cglib.proxy.Proxy;

import org.junit.Test;

import io.github.xudaojie.proxy.UserService;
import io.github.xudaojie.proxy.UserServiceImpl;

import static org.junit.Assert.*;

public class CglibProxyHandlerTest {

    /**
     *
     */
    @Test
    public void proxy() {
        UserService userService = new UserServiceImpl();
        CglibProxyHandler cglibProxyHandler = new CglibProxyHandler(userService);
        UserService proxy = (UserService) Proxy.newProxyInstance(
            UserService.class.getClassLoader(), new Class[] {UserService.class}, cglibProxyHandler);
        proxy.login();
    }
}