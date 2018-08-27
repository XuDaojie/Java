package com.ald.news;

import com.ald.news.user.UserApplication;
import com.ald.news.user.config.UserRedisTemplate;
import com.ald.news.user.consts.TaskConst;
import com.ald.news.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by Kai on 2018/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class RedisUserTests {

    @Resource(name = "userRedisTemplate")
    private UserRedisTemplate redisTemplate;

    @Test
    public void testingRedisUser(){

        // 记录今日贡献师徒奖励用户
        for (int i = 100;i<110;i++){
            String user = ""+i;
            String readTeacherKey = TaskConst.Redis.USER_TEACHER_READ + i;
            redisTemplate.opsForSet().add(readTeacherKey,user);
            // 用户今日已贡献师徒奖励用户列表保存在一个List中，定时清理
            redisTemplate.opsForSet().add(Constants.Global.READ_TEACHER_COUNT_KEY, readTeacherKey);
        }

    }

    @Test
    public void testRead(){
            String user = "" + 55621;
            String readTeacherKey = TaskConst.Redis.USER_TEACHER_READ + 55621;
            String readTeacherKey1 = TaskConst.Redis.USER_FORBEARS_READ + 55621;
            boolean readKey = redisTemplate.opsForSet().isMember(readTeacherKey, user);
            boolean readKey1 = redisTemplate.opsForSet().isMember(readTeacherKey1, user);
            System.err.println("readKey:"+readKey);
            System.err.println("readKey1:"+readKey1);
            System.err.println("readTeacherKey:"+redisTemplate.opsForSet().members(readTeacherKey));
            System.err.println("readTeacherKey1"+redisTemplate.opsForSet().members(readTeacherKey1));
    }
    @Test
    public void test() {
        Set<String> readCountKeys = redisTemplate.opsForSet().members(Constants.Global.READ_TEACHER_COUNT_KEY);
        readCountKeys.add(Constants.Global.READ_TEACHER_COUNT_KEY);
        redisTemplate.delete(readCountKeys);
        System.err.println("清除徒弟贡献阅读用户列表");
        Set<String> readNewsKeys = redisTemplate.opsForSet().members(Constants.Global.READ_FORBEARS_COUNT_KEY);
        readNewsKeys.add(Constants.Global.READ_FORBEARS_COUNT_KEY);
        redisTemplate.delete(readNewsKeys);
        System.err.println("清除徒孙贡献阅读用户列表");
    }

}
