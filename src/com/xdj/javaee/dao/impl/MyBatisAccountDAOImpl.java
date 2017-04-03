package com.xdj.javaee.dao.impl;

import com.xdj.javaee.bean.AccountBean;
import com.xdj.javaee.dao.AccountDAO;

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

    @Override
    public AccountBean getAccount(String username) {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            AccountBean accountBean = sqlSession.selectOne("findAccountByName", username);
            sqlSession.close();
            return accountBean;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addAccount(AccountBean accountBean) {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertAccount", accountBean);
            sqlSession.commit();
            sqlSession.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
