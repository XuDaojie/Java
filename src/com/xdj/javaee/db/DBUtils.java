package com.xdj.javaee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by xdj on 2017/4/1.
 */
public class DBUtils {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static void m1() throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获得连接
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        // 通过数据库连接操作数据库
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM account");
        System.out.println("---------------");
        while (rs.next()) {
            System.out.println(
                    rs.getString("username") + " " +
                    rs.getString("password"));
        }
        System.out.println("---------------");
    }
}
