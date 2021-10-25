package io.github.xudaojie.spring.aop.aspectj.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XuDaojie
 * @since 2021/10/25
 */
@Slf4j
public class ProxyLogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("proxy ---------before");
        Object obj = invocation.proceed();
        log.info("proxy ---------after");
        return obj;
    }
}
