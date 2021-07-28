package io.github.xudaojie.spring.aop.aspectj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XuDaojie
 * @since 2021/7/28
 */
@RestController
public class EchoController {

    @RequestMapping("/echo")
    public String echo(String a) {
        System.out.println(a);
        return a;
    }
}
