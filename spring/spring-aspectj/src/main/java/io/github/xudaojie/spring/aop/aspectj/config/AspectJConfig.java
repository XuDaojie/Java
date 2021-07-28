package io.github.xudaojie.spring.aop.aspectj.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * @author XuDaojie
 * @since 2021/7/28
 */
@Configuration
@Aspect
public class AspectJConfig {

    @Before("execution(* io.github.xudaojie.spring.aop.aspectj.controller.EchoController.echo(..)) && args(a)")
    public void log(String a) {
        System.out.println("log: param a=" + a);
    }
}
