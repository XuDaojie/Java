package io.github.xudaojie.javase.collection;

import com.google.common.base.Stopwatch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author XuDaojie
 * @since 2021/4/24
 */
public class ListTest {

    /**
     * debug测试ArrayList扩容
     */
    @Test
    public void arrayListTest() {
        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
    }

    /**
     * 声明容量和不声明容量性能差距
     */
    @Test
    public void arrayListAddTest() {
        int capacity = 100000;

        Stopwatch stopwatch = Stopwatch.createStarted();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(i + "");
        }
        System.out.println("add: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        stopwatch = Stopwatch.createStarted();
        List<String> list2 = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            list2.add(i, i + "");
        }
        System.out.println("add2:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }
}
