package com.ald.news.service;

import com.ald.news.user.service.impl.UserAwardServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kaizen on 2018/3/29.
 */
public class UserServiceTests {

    @Test
    public void testingGetRedPackageMoney() {
        UserAwardServiceImpl service = new UserAwardServiceImpl();
        float high = 0;
        float low = 0;
        float middle = 0;
        int count = 1000000;
        for (int i = 0; i < count; i++) {
            int n = service.getRedPackageMoney();
            //     90% 获得 0.5 - 1.5元 10% 获得 1.5 - 3元
//            if (n > 150) {
//                assertTrue(n <= 300);
//                high++;
//            } else {
//                assertTrue(n >= 50);
//                low++;
//            }

    //     2.5-3.5的概率70%，3.5-4的概率20%，1.5-2.5概率10%
                if (n >= 350 && n<=400) {
//                    assertTrue(n <= 400 && n>=350);
                    high++;
                }else if (n >= 250 && n<=350) {
//                    assertTrue(n >= 250 && n<=300);
                    middle++;
                } else {
//                    assertTrue(n >= 150 && n<=250);
                    low++;
                }
        }
        System.out.println("higt: " + high + "------------ middle: " + middle +" ------------ low: " + low);
        System.out.println("high: " + high / count * 100 + "% ---------- middle: " +middle/count*100 +"% ---------- low: " + low / count * 100 + "%");
    }
}
