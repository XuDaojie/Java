package io.github.xudaojie.javase.io;

import com.google.common.base.Stopwatch;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author XuDaojie
 * @since 2020/12/14
 */
public class ReadBigFileTest {

    @Test
    public void readFile() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = new File("/Users/xdj/Downloads/arc_borrow_rule_result.sql");
        try {
            List<String> lineList = FileUtils.readLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void readFileLine() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = new File("/Users/xdj/Downloads/arc_borrow_rule_result.sql");
        try {
            LineIterator iterator = FileUtils.lineIterator(file);
            while (iterator.hasNext()) {
                String line = iterator.nextLine();
                System.out.println(line);
                break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
