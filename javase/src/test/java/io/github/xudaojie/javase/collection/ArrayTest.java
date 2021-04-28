package io.github.xudaojie.javase.collection;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author XuDaojie
 * @since 2021/4/24
 */
public class ArrayTest {

    @Test
    public void sortTest() {
        int[] numbers = new int[] {1, 5, 3};
        Arrays.sort(numbers);
        System.out.println(numbers);
    }
}
