package io.github.xudaojie.templates.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //初始器和监听器在这一步添加完毕
        SpringApplication application = new SpringApplication(Application.class);
        //应用启动
        application.run(args);
    }
}

