package io.github.xudaojie.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xdj
 * @date 2019-01-14
 */
@ConfigurationProperties(prefix = "greeting")
public class GreetingProperties {

    private String value = "Hello World!";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
