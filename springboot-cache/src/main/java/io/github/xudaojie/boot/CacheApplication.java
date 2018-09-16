package io.github.xudaojie.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xdj on 2018-09-17.
 */
@SpringBootApplication // 开启组件扫描和自动配置
@RestController
public class CacheApplication extends WebMvcConfigurerAdapter {

    @RequestMapping({"/"})
    public String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }
}
