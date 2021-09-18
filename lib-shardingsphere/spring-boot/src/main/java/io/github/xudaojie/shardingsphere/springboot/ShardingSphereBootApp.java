package io.github.xudaojie.shardingsphere.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author XuDaojie
 * @since 2021/8/10
 */
@RestController
@SpringBootApplication
public class ShardingSphereBootApp {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereBootApp.class);
    }

    @Resource
    DataSource dataSource;

    @PostMapping("/sharding")
    public String test() throws SQLException {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO `demo`.`t_foo_ss`(`foo`) VALUES ('foo2021-07-29 11:52:24foo1111')");
        }
        return "Hello World!";
    }
}
