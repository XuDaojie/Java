package com.xdj.javaee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by xdj on 2017/5/16.
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @RequestMapping("set")
    public String redisSet(@RequestParam("key") String key,
                           @RequestParam("value") String val) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.199.211");

        Jedis jedis = pool.getResource();
        String result = jedis.set(key, val);
        jedis.close();

        pool.destroy();

        return result;
    }

    @RequestMapping("get")
    public String redisGet(@RequestParam("key") String key) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.199.211");

        Jedis jedis = pool.getResource();
        String value = jedis.get(key);
        jedis.close();

        pool.destroy();
        return value;
    }

    @RequestMapping("lpush")
    public String redisLpush(@RequestParam("key") String key,
                             @RequestParam("value") String val) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.199.211");

        Jedis jedis = pool.getResource();
        Long size = jedis.lpush(key, val);
        jedis.close();

        pool.destroy();
        return size + "";
    }

    @RequestMapping("lrange")
    public String redisGet(@RequestParam("key") String key,
                           @RequestParam(value = "start", defaultValue = "0") Long start,
                           @RequestParam(value = "end", defaultValue = "-1") Long end) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.199.211");

        Jedis jedis = pool.getResource();
        List<String> values = jedis.lrange(key, start, end);
        jedis.close();

        pool.destroy();
        return values.toString();
    }
}
