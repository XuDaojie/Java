package io.github.xudaojie.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xdj
 * @date 2018/8/27
 */
@RestController("/demo")
public class GreetingController {

    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/index")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/bad")
    public String bad() {
        return "{'msg', 'bad'}";
    }

    @GetMapping("/suucess")
    public String success() {
        return "succuess";
    }
}
