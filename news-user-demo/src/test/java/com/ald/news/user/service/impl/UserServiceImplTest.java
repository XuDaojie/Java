package com.ald.news.user.service.impl;

import com.ald.news.core.Response;
import com.ald.news.user.config.SingleRedisTemplate;
import com.ald.news.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by xuxm on 2018/7/19
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private SingleRedisTemplate singleRedisTemplate;

    @Test
    public void getEMSmsCode() {
        Long mobile = 13411110000L;
        for (int i = 0; i < 10; i++) {
            mobile++;
            Response emSmsCode = userService.getEMSmsCode(String.valueOf(mobile));
            System.out.println(emSmsCode);
            String code = singleRedisTemplate.opsForValue().get("testserver:sms:" + mobile);
            System.out.println(code);
            Response response = userService.mediaRegister(String.valueOf(mobile), code);
            System.out.println(response);
        }
    }
}