package com.ald.news.config;

import com.ald.news.user.UserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Kai on 2018/7/14.
 */
@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisUserConfigTests {

    @Autowired
    RedisTemplate<String, String> userRedisTemplate;

    @Test
    public void testingRedis() {
        userRedisTemplate.opsForValue().set("testing", "123");
    }


}
