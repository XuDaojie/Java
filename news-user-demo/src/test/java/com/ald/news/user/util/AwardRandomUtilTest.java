package com.ald.news.user.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangfeng
 * @date 2018/6/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AwardRandomUtilTest {

    @Test
    public void generateJson(){
        // [{"min":1,"max":10,"probability":50},{"min":11,"max":30,"probability":40},{"min":31,"max":80,"probability":10}]
        List list = new ArrayList();
        AwardRandomUtil.AwardRandom random1 = new AwardRandomUtil.AwardRandom();
        random1.setProbability(50);
        random1.setMin(1);
        random1.setMax(10);
        list.add(random1);

        AwardRandomUtil.AwardRandom random2 = new AwardRandomUtil.AwardRandom();
        random2.setProbability(40);
        random2.setMin(11);
        random2.setMax(30);
        list.add(random2);

        AwardRandomUtil.AwardRandom random3 = new AwardRandomUtil.AwardRandom();
        random3.setProbability(10);
        random3.setMin(31);
        random3.setMax(80);
        list.add(random3);

        System.out.println("-------------------");
        System.out.println(JSON.toJSON(list));
    }

    @Test
    public void random() {
        String json = "[{\"min\":1,\"max\":10,\"probability\":50},{\"min\":11,\"max\":30,\"probability\":40},{\"min\":31,\"max\":80,\"probability\":10}]";
        List<AwardRandomUtil.AwardRandom> list = JSON.parseArray(json, AwardRandomUtil.AwardRandom.class);

        System.out.println(list);

        double count1 = 0, count2 = 0, count3 = 0;
        double times = 1 * 10000;
        for(int i=0; i<times; i++){
            int random = AwardRandomUtil.random(list);
            System.out.println("生成的随机数"+random);
            if(random >= 1 && random <= 10){
                count1++;
            }
            else if(random >= 11 && random <= 30){
                count2++;
            }
            else if(random >= 31 && random <= 80){
                count3++;
            }
        }

        System.out.println("------------------------");
        System.out.println("区间1出现的次数:"+count1+",出现的概率:"+(count1/times)*100);
        System.out.println("区间2出现的次数:"+count2+",出现的概率:"+(count2/times)*100);
        System.out.println("区间3出现的次数:"+count3+",出现的概率:"+(count3/times)*100);
        System.out.println("------------------------");
    }
}