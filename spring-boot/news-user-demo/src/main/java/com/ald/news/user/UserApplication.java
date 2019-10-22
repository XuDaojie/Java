package com.ald.news.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ald.news"}) // 注册Filter\Listener\Servlet使用
@EnableCaching
@EnableEurekaClient
public class UserApplication {

    public static void main(String[] args) {
        //初始器和监听器在这一步添加完毕
        SpringApplication application = new SpringApplication(UserApplication.class);
        //应用启动
        application.run(args);
    }
}

