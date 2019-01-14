package io.github.xudaojie.autoconfigure;

import io.github.xudaojie.emptyjar.Greeting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xdj
 * @date 2019/1/10
 */
@Configuration
@ConditionalOnClass(Greeting.class)
public class GreetingConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Greeting greeting() {
        return new Greeting();
    }
}
