package com.xdj.javaee.dao.impl;

import com.xdj.javaee.bean.AccountBean;
import com.xdj.javaee.dao.AccountDAO;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by xdj on 2017/4/2.
 */
public class AccountDAOImpl implements AccountDAO {

    private DriverManagerDataSource mDataSource;
    private Connection mConnection;

    public void setDataSource(DriverManagerDataSource dataSource) {
        mDataSource = dataSource;
        try {
            mConnection = mDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AccountBean getAccount(String username) {
//        Connection conn = DBUtils.getConnection();
        try {
            Statement statement = mConnection.createStatement();
            String sql = String.format("select * from account where username = '%s'",
                    username);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                AccountBean accountBean = new AccountBean();
                accountBean.setUsername(resultSet.getString("username"));
                accountBean.setPassword(resultSet.getString("password"));
                return accountBean;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addAccount(AccountBean accountBean) {
//        Connection conn = DBUtils.getConnection();
        try {
            Statement statement = mConnection.createStatement();
            String sql = String.format("INSERT INTO account(username, password) VALUES ('%s', '%s')",
                    accountBean.getUsername(), accountBean.getPassword());
            long size = statement.executeUpdate(sql);
            if (size > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
