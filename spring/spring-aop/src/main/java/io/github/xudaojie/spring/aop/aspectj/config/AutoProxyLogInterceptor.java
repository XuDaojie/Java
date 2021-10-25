package io.github.xudaojie.spring.aop.aspectj.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XuDaojie
 * @since 2021/10/25
 */
@Slf4j
public class AutoProxyLogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("auto proxy---------before");
        Object obj = invocation.proceed();
        log.info("auto proxy---------after");
        return obj;
    }
}
