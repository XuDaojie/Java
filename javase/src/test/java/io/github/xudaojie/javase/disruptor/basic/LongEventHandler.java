package io.github.xudaojie.javase.disruptor.basic;

import com.lmax.disruptor.EventHandler;

/**
 * 事件处理
 *
 * @author XuDaojie
 * @since 2020/7/23
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("消费者: " + Thread.currentThread().getName() + "; Event: " + event
            + "; sequence: " + sequence + "; endOfBatch: " + endOfBatch
            + "; Value: " + event.getValue());
    }
}
