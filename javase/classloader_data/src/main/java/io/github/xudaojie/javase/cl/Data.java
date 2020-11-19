package io.github.xudaojie.javase.cl;

import java.util.Objects;

/**
 * @author XuDaojie
 * @since 2020/9/27
 */
public class Data {

    private String data = "111";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        Data data1 = (Data) o;
        return data.equals(data1.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
