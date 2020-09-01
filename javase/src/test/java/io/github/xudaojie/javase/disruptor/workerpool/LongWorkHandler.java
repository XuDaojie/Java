package io.github.xudaojie.javase.disruptor.workerpool;

import com.lmax.disruptor.WorkHandler;

import io.github.xudaojie.javase.disruptor.basic.LongEvent;

/**
 * @author XuDaojie
 * @since 2020/8/28
 */
public class LongWorkHandler implements WorkHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event) throws Exception {
//        Thread.sleep(1000);
        System.out.println("timestamp: " + System.currentTimeMillis()
            + "; " + Thread.currentThread().getName() + "; Event: " + event
            + "; Value: " + event.getValue());
    }
}
