package io.github.xudaojie.boot.mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

/**
 * Created by xdj on 2017/5/18.
 */
@SpringBootApplication // 开启组件扫描和自动配置
@RestController
public class MappingApplication extends WebMvcConfigurerAdapter {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 开启URI矩阵
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

//    @RequestMapping({"/", "greeting"})
//    public String home() {
//        return "Hello World!";
//    }

    /**
     *
     * @param userId 通过正则表达式限制传入参数格式
     * @return
     */
    @RequestMapping({"/users/{userId:[\\d]+}"})
    public String urlRegex(@PathVariable String userId) {
        return "userId: " + userId;
    }

    @RequestMapping(path = "/${spring.application.name}/")
    public String httpStatus(@PathVariable("spring.application.name") String name) {
        return "Hello World!";
    }

    /**
     * 矩阵变量(矩阵URI)
     * https://www.w3.org/DesignIssues/MatrixURIs.html
     * Spring Boot中默认无法使用
     * 开启方式(https://stackoverflow.com/questions/30539783/spring-mvc-missing-matrix-variable)
     * @return
     */
    @RequestMapping("/pets/{petId}")
    public String matrix(@PathVariable String petId,
                         @MatrixVariable Long q) {
        return petId + ";" + q;
    }

    /**
     * 参数限制,当myParam=myValue时，进入此函数
     * @param petId
     * @return
     */
    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET,
            params="myParam=myValue")
    public String findPet(@PathVariable String petId) {
        // 实际实现省略
        return petId + ";";
    }

    /**
     * 参数限制,当page=1时，进入此函数
     * @param petId
     * @return
     */
    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.POST,
            params="page=1")
    public String findPet(@PathVariable String petId, @RequestParam Long page) {
        // 实际实现省略
        return petId + ";page=" + page;
    }

    public static void main(String[] args) {
        SpringApplication.run(MappingApplication.class, args);
    }
}
