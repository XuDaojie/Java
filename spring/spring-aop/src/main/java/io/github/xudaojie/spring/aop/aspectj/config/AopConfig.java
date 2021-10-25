package io.github.xudaojie.spring.aop.aspectj.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.interceptor.DebugInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.xudaojie.spring.aop.aspectj.service.EchoService;
import io.github.xudaojie.spring.aop.aspectj.service.EchoServiceImpl;

/**
 * @author XuDaojie
 * @since 2021/10/26
 */
@Configuration
public class AopConfig {

    @Bean
    public DebugInterceptor debugInterceptor() {
        return new DebugInterceptor();
    }

    @Bean
    public ProxyLogInterceptor proxyLogInterceptor() {
        return new ProxyLogInterceptor();
    }

    @Bean(name = "proxyEchoService")
    public ProxyFactoryBean proxyEchoService(EchoService echoService) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(echoService);
        proxyFactoryBean.setInterceptorNames("debugInterceptor", "proxyLogInterceptor");
        return proxyFactoryBean;
    }

    // ------------
    @Bean
    public AutoProxyLogInterceptor autoProxyLogInterceptor() {
        return new AutoProxyLogInterceptor();
    }

    @Bean(name = "autoProxyEchoService", autowireCandidate = false)
    public EchoService autoProxyEchoService() {
        return new EchoServiceImpl();
    }

    /**
     * 根据bean名称自动匹配aop
     */
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
        creator.setBeanNames("auto*");
        creator.setInterceptorNames("autoProxyLogInterceptor");
        return creator;
    }

}
