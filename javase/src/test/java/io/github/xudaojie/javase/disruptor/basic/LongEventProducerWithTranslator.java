package io.github.xudaojie.javase.disruptor.basic;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * 发布消息-翻译器
 *
 * @author XuDaojie
 * @since 2020/7/23
 */
public class LongEventProducerWithTranslator {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR = new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
        @Override
        public void translateTo(LongEvent event, long sequence, ByteBuffer byteBuffer) {
            event.setValue(byteBuffer.getLong(0));
        }
    };

    public void onData(ByteBuffer byteBuffer) {
        ringBuffer.publishEvent(TRANSLATOR, byteBuffer);
    }
}
