package io.github.xudaojie.javaee.dao.impl;

import io.github.xudaojie.javaee.bean.AccountBean;
import io.github.xudaojie.javaee.dao.AccountDAO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xdj on 2017/4/3.
 */
public class MyBatisAccountDAOImpl implements AccountDAO {

    private static SqlSessionFactory sSqlSessionFactory = null;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AccountBean getAccount(String username) {
        SqlSession sqlSession = sSqlSessionFactory.openSession();
        AccountBean accountBean = sqlSession.selectOne("findAccountByName", username);
        sqlSession.close();
        return accountBean;
    }

    @Override
    public boolean addAccount(AccountBean accountBean) {
        SqlSession sqlSession = sSqlSessionFactory.openSession();
        sqlSession.insert("insertAccount", accountBean);
        sqlSession.commit();
        sqlSession.close();
        return false;
    }
}
