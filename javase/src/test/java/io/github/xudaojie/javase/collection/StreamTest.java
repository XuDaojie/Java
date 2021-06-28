package io.github.xudaojie.javase.collection;

import com.sun.tools.javac.util.List;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.Stream;

import lombok.Data;

/**
 * @author XuDaojie
 * @since 2021/6/28
 */
public class StreamTest {

    /**
     * 使用Stream打印集合
     */
    @Test
    public void mapParallelTest() {
        List.of("1", "2", "3", "4", "5", "6")
            .stream().parallel()
            .map((Function<String, Object>) s -> s)
            .forEach(System.out::println);
    }

    /**
     * 打印学生的所有课程
     */
    @Test
    public void flatMapTest() {
        Student s1 = new Student();
        s1.setName("狗剩");
        s1.setCourses(List.of("1英语", "2数学"));
        Student s2 = new Student();
        s2.setName("二狗");
        s2.setCourses(List.of("1英语", "2数学", "3语文"));

        List.of(s1, s2)
            .stream()
            .flatMap((Function<Student, Stream<?>>) student -> student.getCourses().stream())
            .forEach(System.out::println);

    }

    @Data
    private class Student {
        String name;
        List<String> courses;
    }
}
