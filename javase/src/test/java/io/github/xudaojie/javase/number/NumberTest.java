package io.github.xudaojie.javase.number;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author XuDaojie
 * @since 2021/5/7
 */
public class NumberTest {

    /**
     * 浮点运算误差
     * 结果不为1
     */
    @Test
    public void floatTest() {
        float i = 0f;
        for (int j = 0; j < 10; j++) {
            i = i + 0.1f;
        }
        System.out.println(i);
    }

    /**
     * BigDecimal也无法确保精度
     */
    @Test
    public void bigDecimalTest() {
        BigDecimal decimal = new BigDecimal(1.111d);
        BigDecimal sum = decimal.add(new BigDecimal(0.9d));
        System.out.println(sum);

        BigDecimal decimal1 = new BigDecimal(2.2d);
        System.out.println(decimal1.divide(new BigDecimal(2.0d)));

        BigDecimal decimal2 = new BigDecimal("21.211");
        System.out.println(decimal2.divide(new BigDecimal("2.0")));
    }
}
