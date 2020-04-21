package io.github.xudaojie.javase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionTest {

    @Test
    public void listTest() {
        List<String> list = new ArrayList<>();
        list.add("");

        int len = 100_0000;
        List<String> a = new ArrayList<>();
        List<String> b = new LinkedList<>();
        long timestamp1 = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            a.add("i=" + i);
        }
        long timestamp2 = System.currentTimeMillis();
        long duration1 = timestamp2 - timestamp1;
        System.out.println("ArrayList: " + duration1);
        for (int i = 0; i < len; i++) {
            b.add("i=" + i);
        }
        long timestamp3 = System.currentTimeMillis();
        long duration2 = timestamp3 - timestamp2;
        System.out.println("LinkedList: " + duration2);
    }
}
