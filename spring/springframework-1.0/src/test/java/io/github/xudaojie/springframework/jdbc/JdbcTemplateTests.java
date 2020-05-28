package io.github.xudaojie.springframework.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JdbcTemplateTests {

    private BeanFactory beanFactory;
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private DataSourceTransactionManager transactionManager;

    @Before
    public void before() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("jdbc/dao-beans.xml");
        beanFactory = new XmlBeanFactory(resource);
        dataSource = (DriverManagerDataSource) beanFactory.getBean("dataSource");
        jdbcTemplate = (JdbcTemplate) beanFactory.getBean("jdbcTemplate");
        transactionManager = (DataSourceTransactionManager) beanFactory.getBean("transactionManager");
    }

    @Test
    public void queryTest() {
        String sql = "SELECT * FROM user";
        List<Map> result = jdbcTemplate.queryForList(sql);
        assertTrue(result != null && result.size() > 0);
    }

    @Test
    public void updateTest() {
        String sql = "update user set password = '654321' where id = 1";
        int result = jdbcTemplate.update(sql);
        assertTrue(result == 1);
    }

    /**
     * 事务出错回滚
     */
    @Test
    public void transactionTest() {
        Connection conn = DataSourceUtils.getConnection(dataSource);
        Statement statement = null;
        try {
            statement = conn.createStatement();

            statement.executeUpdate("update user set password = '654321' where id = 1");

            conn.setAutoCommit(false);
            statement.executeUpdate("update user set password = '123456' where id = 1");
            statement.executeUpdate("update user set password = '654321' where _id = 1");
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 校验数据是否正确
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE id = 1");
            String password = resultSet.getString("password");
            assertEquals("654321", password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
