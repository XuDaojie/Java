package com.ald.news.user.service.impl;

import com.ald.news.core.Response;
import com.ald.news.user.service.DailyTaskService;
import org.junit.Assert;
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
public class DailyTaskServiceImplTest {

    @Autowired
    private DailyTaskService dailyTaskService;

//    /**
//     * 阅读奖励测试
//     */
//    @Test
//    public void readReward() {
//        Long userId = 55054L;
//        String dataId = "EEB4EBEEB4EB9CEE9F22D2C9A07BDC8CB2A84F090E9415";
//        Response response = dailyTaskService.readReward(userId, dataId);
//        Assert.assertTrue(response.getCode() == Response.Status.OK.getStatusCode());
//    }
}