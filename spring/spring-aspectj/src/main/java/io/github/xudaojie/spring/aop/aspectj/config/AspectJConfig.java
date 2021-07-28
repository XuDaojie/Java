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
    public void logController(String a) {
        System.out.println("logController: param a=" + a);
    }

    @Before("execution(* io.github.xudaojie.spring.aop.aspectj.service.EchoService.echo(..)) && args(a)")
    public void logService(String a) {
        System.out.println("logService: param a=" + a);
    }
}
