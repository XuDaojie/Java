package io.github.xudaojie.boot.configuration;

import io.github.xudaojie.boot.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xdj
 * @date 2019/1/11
 */
@Configuration
public class TestConfiguration {

    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName("test bean");
        return testBean;
    }
}
