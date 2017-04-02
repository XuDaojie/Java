package com.xdj.javaee.db.impl;

import com.xdj.javaee.bean.AccountBean;
import com.xdj.javaee.db.AccountDAO;
import com.xdj.javaee.db.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by xdj on 2017/4/2.
 */
public class AccountDAOImpl implements AccountDAO {

    @Override
    public AccountBean getAccount(String username) {
        Connection conn = DBUtils.getConnection();
        try {
            Statement statement = conn.createStatement();
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
}
