package io.github.xudaojie.spring.aop.aspectj;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.interceptor.DebugInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.xudaojie.spring.aop.aspectj.config.LogInterceptor;
import io.github.xudaojie.spring.aop.aspectj.service.EchoService;

/**
 * @author xdj
 */
@SpringBootApplication
public class Application2xAop {

    public static void main(String[] args) {
        SpringApplication.run(Application2xAop.class);
    }

    @Bean
    public DebugInterceptor debugInterceptor() {
        return new DebugInterceptor();
    }

    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }

    @Bean(name = "proxyEchoService")
    public ProxyFactoryBean echo(EchoService echoService) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(echoService);
        proxyFactoryBean.setInterceptorNames("debugInterceptor", "logInterceptor");
        return proxyFactoryBean;
    }

}
