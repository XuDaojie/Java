package io.github.xudaojie.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xdj on 2017/5/18.
 */
@SpringBootApplication // 开启组件扫描和自动配置
@EnableEurekaServer
public class EurekaApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
