package io.github.xudaojie.javase.disruptor.basic;

import com.lmax.disruptor.EventFactory;

/**
 * 分配事件
 *
 * @author XuDaojie
 * @since 2020/7/23
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
