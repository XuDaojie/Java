package io.github.xudaojie.spring.aop.aspectj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.github.xudaojie.spring.aop.aspectj.service.EchoService;

/**
 * @author XuDaojie
 * @since 2021/10/24
 */
@RestController
public class EchoController {

    @Resource(name = "proxyEchoService")
    private EchoService echoService;

    @Resource(name = "autoProxyEchoService")
    private EchoService autoProxyEchoService;

    /**
     * 使用 ProxyFactoryBean 实现aop
     */
    @RequestMapping("/echo")
    public String echo(String a) {
        echoService.echo(a);
        return a;
    }

    /**
     * 使用 自动代理 实现aop
     */
    @RequestMapping("/echo/autoproxy")
    public String autoproxy(String a) {
        autoProxyEchoService.echo(a);
        return a;
    }
}
