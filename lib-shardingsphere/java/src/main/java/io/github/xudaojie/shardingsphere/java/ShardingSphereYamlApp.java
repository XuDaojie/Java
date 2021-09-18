package io.github.xudaojie.shardingsphere.java;

import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlEncryptDataSourceFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

import javax.sql.DataSource;

/**
 * @author XuDaojie
 * @since 2021/8/9
 */
public class ShardingSphereYamlApp {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        File file = new File("/Users/xdj/IdeaProjects/Java/lib-shardingsphere/java/src/main/resources/sharding.yml");
        new BufferedReader(new FileReader(file)).lines().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        DataSource dataSource = YamlEncryptDataSourceFactory.createDataSource(file);

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        stmt.execute("INSERT INTO `demo`.`t_foo_ss`(`foo`) VALUES ('foo2021-07-29 11:52:24foo1111')");
        ResultSet rs = stmt.executeQuery("SELECT * FROM demo.t_foo_ss");
        while (rs.next()) {
            System.err.println(
                "id:" + rs.getInt("id") + ","
                    + "foo:" + rs.getString("foo") + ","
                    + "foo_aes" + rs.getString("foo_aes"));
        }
        stmt.close();
//        Bootstrap.class.getResource("/sharding.yml");
    }
}
