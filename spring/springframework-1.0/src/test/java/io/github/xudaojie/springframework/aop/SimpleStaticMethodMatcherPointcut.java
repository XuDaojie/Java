package io.github.xudaojie.springframework.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method m, Class targetClass) {
        return true;
    }

}
