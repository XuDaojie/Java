package com.ald.news.service;

import com.ald.news.user.consts.TaskConst;
import com.ald.news.utils.java.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by kaizen on 2018/4/3.
 */
public class DailyTaskServiceTests {

    @Test
    public void testingNewReadList() {
        Jedis jedis = new Jedis("localhost");
        final String dateKey = TaskConst.Redis.READ_DATE + String.valueOf(690);
        // 获取新人用户连续阅读日期
        Set<String> keys = jedis.hkeys(dateKey);
        Timestamp timestamp = Timestamp.from(Instant.ofEpochSecond(1523414392));
        // 初始化一个30天的Map容器
        // 0 未完成 1 已完成 2 日期未到
        Map<Long, Integer> date = new HashMap<>();
        long currentDay = DateUtil.getNumberOfDaysBetweenDates(timestamp, Timestamp.from(Instant.now()));
        for (int i = 1; i <= 30; i++) {
            // 今天与未到的日期设置为 2
            if ((currentDay + 1) <= i) {
                date.put((long) i, 2);
            } else {
                // 默认设置为未完成
                date.put((long) i, 0);
            }
        }
        keys.forEach(obj -> {
            long day = DateUtil.getNumberOfDaysBetweenDates(timestamp,
                    Date.from(Instant.ofEpochSecond(Long.valueOf(String.valueOf(obj)))));
            System.out.println("day: " + day);
            // 只记录30天，超过的不计算
            if ((day + 1) <= 30) {
                // 按照记录的时间戳获取是否完成新人阅读
                String v = jedis.hget(dateKey, obj);
                if (v.equals("true")) {
                    date.put(day + 1, 1);
                }
            }
        });
        try {
            String json = new ObjectMapper().writer().writeValueAsString(date);
            System.out.printf("date: %s\n", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testingReadExpire() {
        Jedis jedis = new Jedis("localhost");
        String key = "Hello";
        String value = jedis.get(key);
        if (value != null && !value.isEmpty()) {
            System.out.println("OK");
        }
        jedis.set(key, String.valueOf(System.currentTimeMillis()/1000));
        jedis.expire(key, 8);
    }

    @Test
    public void testingDay() {
        Timestamp timestamp = Timestamp.from(Instant.ofEpochSecond(1523414392));
        long day = DateUtil.getNumberOfDaysBetweenDates(timestamp,
                Date.from(Instant.ofEpochSecond(1524790670)));
        System.out.println(day);
    }
}
