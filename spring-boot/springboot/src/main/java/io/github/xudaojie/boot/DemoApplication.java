package io.github.xudaojie.boot;

import io.github.xudaojie.autoconfigure.EnableGreetingConfiguration;
import io.github.xudaojie.boot.bean.TestBean;
import io.github.xudaojie.emptyjar.Greeting;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xdj on 2017/5/18.
 */
@EnableGreetingConfiguration
@RestController
//@SpringBootApplication(scanBasePackages = "io.github.xudaojie")
@SpringBootApplication
public class DemoApplication extends WebMvcConfigurerAdapter {

    @Resource
    private TestBean testBean;

    @Resource
    private Greeting greeting;

    @RequestMapping({"/"})
    public String home() {
        return testBean.getName();
//        return "Hello World!";
//        return greeting.print();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
