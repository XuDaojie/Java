package com.ald.news.user.service.impl;

import com.ald.news.user.service.UserLevelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author yangfeng
 * @date 2018/6/23
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserLevelServiceImplTest {

    @Autowired
    private UserLevelService userLevelService;

    @Test
    public void updateLevel() {
        userLevelService.updateLevel(54900L);
    }
}