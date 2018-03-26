package com.xdj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xdj on 2017/5/18.
 */
@SpringBootApplication // 开启组件扫描和自动配置
//@EnableAutoConfiguration
@RestController
public class DemoApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @PatchMapping("/patch")
    String patch(@RequestParam("param1") String param1,
                 @RequestParam(value = "param2", required = false)String param2) {
        return param1;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
