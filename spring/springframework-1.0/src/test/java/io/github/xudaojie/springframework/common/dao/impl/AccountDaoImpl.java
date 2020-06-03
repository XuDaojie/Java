package io.github.xudaojie.springframework.common.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import io.github.xudaojie.springframework.common.AccountBean;
import io.github.xudaojie.springframework.common.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public AccountBean selectAccount(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AccountBean selectAccount(String username) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int insertAccount(AccountBean accountBean) {
        String[] args = new String[] {accountBean.getName(), accountBean.getPassword()};
        return jdbcTemplate.update("INSERT INTO user(username, password) values (?, ?);", args);
    }

    @Override
    public int del(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(String username, String password) {
        throw new UnsupportedOperationException();
    }
}
