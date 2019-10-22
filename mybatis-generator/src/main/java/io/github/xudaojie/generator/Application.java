package io.github.xudaojie.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.github.xudaojie")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
