package io.github.xudaojie.proxy;

/**
 * @author xdj
 * @date 2019/1/7
 */
public class Greeting {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String print() {
        return value;
//        return "Hello";
    }
}
