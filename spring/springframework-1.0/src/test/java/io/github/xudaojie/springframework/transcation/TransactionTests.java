package io.github.xudaojie.springframework.transcation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TransactionTests {

    private BeanFactory beanFactory;
//    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private DataSourceTransactionManager transactionManager;
    private TransactionTemplate transactionTemplate;

    @Before
    public void before() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("dao/dao-beans.xml");
        beanFactory = new XmlBeanFactory(resource);
//        dataSource = (DriverManagerDataSource) beanFactory.getBean("dataSource");
        jdbcTemplate = (JdbcTemplate) beanFactory.getBean("jdbcTemplate");
        transactionManager = (DataSourceTransactionManager) beanFactory.getBean("transactionManager");
        transactionTemplate = (TransactionTemplate) beanFactory.getBean("transactionTemplate");

        refresh();
    }

    /**
     * 实现事务最基本实现方式
     */
    @Test
    public void TransactionManagerTest() {

        TransactionDefinition td = new DefaultTransactionDefinition();
        TransactionStatus ts = transactionManager.getTransaction(td);
//       TransactionDefinition 传null，默认会创建DefaultTransactionDefinition
//        TransactionStatus ts = transactionManager.getTransaction(null);
        try {
            update();
            updateThrowException();
            transactionManager.commit(ts);
        } catch (Exception e) {
//            e.printStackTrace();
            transactionManager.rollback(ts);
            assertEquals("123456", selectByPwd());
        }
    }

    /**
     * 事务模板，简化事务
     */
    @Test
    public void templateTest() throws SQLException {
        // 抛出异常回滚
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                 update();
                 updateThrowException();
            }
        });
    }

    public String selectByPwd() {
        return (String) jdbcTemplate.queryForObject("select password from user where id = 1", String.class);
    }

    public void refresh() {
        jdbcTemplate.update("update user set password = '123456' where id = 1");
    }

    public int update() {
        long pwd = System.currentTimeMillis();
        return jdbcTemplate.update("update user set password = '" + pwd + "' where id = 1");
    }

    /**
     * 调用更新并抛异常
     */
    public int updateThrowException() {
//        try {
            return jdbcTemplate.update("update user set password = '123456' where _id = 1");
//        } catch (UncategorizedSQLException e) {
//            e.printStackTrace();
//        }

//        return -1;
    }

}
