package io.github.xudaojie.javase.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.FatalExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

import io.github.xudaojie.javase.disruptor.basic.LongEvent;
import io.github.xudaojie.javase.disruptor.basic.LongEventFactory;
import io.github.xudaojie.javase.disruptor.basic.LongEventHandler;
import io.github.xudaojie.javase.disruptor.basic.LongEventProducerWithTranslator;
import io.github.xudaojie.javase.disruptor.workerpool.LongWorkHandler;

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
        EventHandler<LongEvent> eventHandler = new LongEventHandler();
        disruptor.handleEventsWith(eventHandler);
        // 启动disruptor以及消费者线程池
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducerWithTranslator eventProducer = new LongEventProducerWithTranslator(ringBuffer);
        // 使用ByteBuffer包装数据，模拟网络请求
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        int len = 100;
        for (long l = 0; l <= len; l++) {
            byteBuffer.putLong(0, l);
            eventProducer.onData(byteBuffer);
        }

        // ----------------------
        while (true) {
            // 获得当前消费的sequence,确保所有事件已消费完毕
            if (ringBuffer.getMinimumGatingSequence() == len) break;
        }
    }

    @Test
    public void workerPoolTest() throws InterruptedException {
        LongEventFactory eventFactory = new LongEventFactory();

        // 缓存环大小，必须为2的幂数
        int bufferSize = 1024;

        // 线程池线程总数
        int tc = 6;

        RingBuffer<LongEvent> ringBuffer = RingBuffer.createSingleProducer(eventFactory, bufferSize);
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        ExceptionHandler<Object> exceptionHandler = new FatalExceptionHandler();
        WorkHandler<LongEvent>[] workHandlers = new LongWorkHandler[tc];
        for (int i = 0; i < tc; i++) {
            workHandlers[i] = new LongWorkHandler();
        }

        WorkerPool<LongEvent> workerPool = new WorkerPool<>(
            ringBuffer,
            sequenceBarrier,
            exceptionHandler,
            workHandlers);
        Sequence[] sequences = workerPool.getWorkerSequences();
        // 监控当前消费序号
        ringBuffer.addGatingSequences(sequences);
        workerPool.start(Executors.newFixedThreadPool(tc));

        int len = 100;
        for (long l = 0; l <= len; l++) {
            long seq = ringBuffer.next();
            ringBuffer.get(seq).setValue(l);
            ringBuffer.publish(seq);
        }


        // ----------------------
        while (true) {
            for (Sequence sequence : sequences) {
                // 确保所有事件消费完毕才结束
                if (sequence.get() == len) return;
            }
        }
    }
}
