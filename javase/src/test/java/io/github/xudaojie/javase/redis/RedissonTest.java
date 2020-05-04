package io.github.xudaojie.javase.redis;

import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.RedissonFairLock;
import org.redisson.RedissonLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RedissonTest {

    private RedissonClient redisson;
    private RedissonClient redissonCluster;

    @Before
    public void after() {
//        redisson = Redisson.create();

        Config config = new Config();
        config.useSingleServer()
            .setAddress("redis://127.0.0.1:6379");
        // 默认序列化方式
//        config.setCodec(new FstCodec());
        config.setCodec(new StringCodec());
        config.setLockWatchdogTimeout(100 * 1000);
        redisson = Redisson.create(config);

        Config configCluster = new Config();
//        106-108
        configCluster.useClusterServers()
            .addNodeAddress("redis://192.168.115.106:7000", "192.168.115.107:7002", "192.168.115.108:7004");
        redissonCluster = Redisson.create(configCluster);
    }

    @Test
    public void stringTest() {
//        RBucket<byte[]> rBucket = redisson.getBucket("redisson:string:test");
//        rBucket.set("value".getBytes());

        RBucket<String> rBucket = redisson.getBucket("redisson:string:test");
        rBucket.set("value", 10, TimeUnit.SECONDS);
        System.out.println(rBucket.get());
    }

    @Test
    public void redissonLockTest() throws InterruptedException {
        RedissonLock lock = (RedissonLock) redisson.getLock("lock1");
        RedissonLock lock1 = (RedissonLock) redisson.getLock("lock1");
        lock.lock();
        lock1.lock();
//        lock.lockAsync();

//        lock.unlock();
        // 读取锁信息
        RMap<String, String> rMap = redisson.getMap("lock1");
        Map<String, String> map = rMap.readAllMap();
        long ttl = lock.remainTimeToLive();
        System.out.println("ttl: " + ttl + " map: " + map);

        while (true) {
            Thread.sleep(1000);
            System.out.println("ttl: " + lock.remainTimeToLive());
        }
//        rMap.delete();
    }

    @Test
    public void redissonRedLockTest() {
        RedissonLock lock1 = (RedissonLock) redissonCluster.getLock("lock1");
        RedissonLock lock2 = (RedissonLock) redissonCluster.getLock("lock2");
//        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2);
        RedissonRedLock redLock = new RedissonRedLock(lock2);
        // 获取锁。如果该锁不可用，则出于线程调度目的，当前线程将被禁用，并处于休眠状态，直到获得该锁为止
//        redLock.lock();
        redLock.lock(300, TimeUnit.SECONDS);

//        redLock.tryLock();
        System.out.println(lock2.remainTimeToLive());
    }

    @Test
    public void failLockTest() {
        RedissonFairLock rLock = (RedissonFairLock) redisson.getFairLock("lock1");
        rLock.tryLock();
    }
}
