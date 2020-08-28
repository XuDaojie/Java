package io.github.xudaojie.javase.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import org.junit.Test;

import java.nio.ByteBuffer;

import io.github.xudaojie.javase.disruptor.basic.LongEvent;
import io.github.xudaojie.javase.disruptor.basic.LongEventFactory;
import io.github.xudaojie.javase.disruptor.basic.LongEventHandler;
import io.github.xudaojie.javase.disruptor.basic.LongEventProducerWithTranslator;

/**
 * @author XuDaojie
 * @since 2020/7/23
 */
public class RingBufferTest {

    /**
     * 高性能环形队列
     */
    @Test
    public void basicDisruptorTest() throws InterruptedException {
        //
        LongEventFactory eventFactory = new LongEventFactory();

        // 缓存环大小，必须为2的幂数
        int bufferSize = 1024;

        // 默认为MultiProducer和BlockingWaitStrategy
        Disruptor<LongEvent> disruptor = new Disruptor<>(eventFactory, bufferSize, DaemonThreadFactory.INSTANCE);
        // 配置事件处理者
        disruptor.handleEventsWith(new LongEventHandler());
        // 启动disruptor以及消费者线程池
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducerWithTranslator eventProducer = new LongEventProducerWithTranslator(ringBuffer);
        // 使用ByteBuffer包装数据，模拟网络请求
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            byteBuffer.putLong(0, l);
            eventProducer.onData(byteBuffer);
            Thread.sleep(1000);
        }

    }
}
