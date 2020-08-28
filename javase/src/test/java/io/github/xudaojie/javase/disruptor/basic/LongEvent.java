package io.github.xudaojie.javase.disruptor.basic;

/**
 * @author XuDaojie
 * @since 2020/7/23
 */
public class LongEvent {
    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
