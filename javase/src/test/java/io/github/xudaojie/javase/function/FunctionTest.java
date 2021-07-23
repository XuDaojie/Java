package io.github.xudaojie.javase.function;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author XuDaojie
 * @since 2021/7/6
 */
public class FunctionTest {

    @Test
    public void functionTest() {

        // 实现int increment 方法
        Function<Integer, Integer> getAndIncrement = value -> ++value;

        System.out.println(getAndIncrement.apply(1));
    }

    @Test
    public void biFunctionTest() {

        // 实现sum 方法
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(1, 2));
    }
}
