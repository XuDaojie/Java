package io.github.xudaojie.springframework.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method m, Class targetClass) {
        System.out.println("Pointcut -> " + this.getClass());
//        return false;
        return true;
    }

}
