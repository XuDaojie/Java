package io.github.xudaojie.boot.valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by xdj on 2017/5/18.
 */
@SpringBootApplication // 开启组件扫描和自动配置
@RestController
public class ValidApplication extends WebMvcConfigurerAdapter {

    /**
     * 数据校验
     * @param user
     * @param result 获得需要校验的值
     * @return
     */
    @RequestMapping("/valid")
    public String valid(@Valid User user, BindingResult result) {
        if (result.getFieldError() != null) {
            return result.getFieldError().getDefaultMessage();
        }
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ValidApplication.class, args);
    }
}
