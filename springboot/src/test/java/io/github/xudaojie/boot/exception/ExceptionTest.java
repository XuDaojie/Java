package io.github.xudaojie.boot.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * @author xdj
 * @date 2018/11/11
 */
public class ExceptionTest {

    @Test
    public void error() {
        try {
            Map map = null;
//            map.put("m", "m");
            throw new NullPointerException("xxxx");
        } catch (RuntimeException e) {
//            e.printStackTrace();
//            throw new RuntimeException("ma" + e.getMessage());
//            throw new RuntimeException("map", e);
        }

    }

    @Test
    public void e() {
        List<String> list = new ArrayList<>();
        list.add("x");
        list.add("d");
        list.add("j");
        list.add("x");
        list.add("d");
        list.add("j");
        for (String s : list) {
            if ("x".equals(s)) {
                list.remove(s);
            }
        }
//        for (int i = 0; i < list.size(); i++) {
//            if ("d".equals(list.get(i))) {
//                list.remove(list.get(i));
//            }
//        }
    }
}
