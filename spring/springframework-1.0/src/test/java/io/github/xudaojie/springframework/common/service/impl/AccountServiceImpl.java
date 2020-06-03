package io.github.xudaojie.springframework.common.service.impl;

import io.github.xudaojie.springframework.common.AccountBean;
import io.github.xudaojie.springframework.common.dao.AccountDao;
import io.github.xudaojie.springframework.common.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public AccountBean selectAccount(long id) {
        return null;
    }

    @Override
    public AccountBean selectAccount(String username) {
        return null;
    }

    @Override
    public int insertAccount(AccountBean accountBean) {
        return 0;
    }

    @Override
    public int insert2Account(AccountBean accountBean1, AccountBean accountBean2) {
        accountDao.insertAccount(accountBean1);
        accountDao.insertAccount(null);
        return 2;
    }

    @Override
    public int del(long id) {
        return 0;
    }

    @Override
    public int update(String username, String password) {
        return 0;
    }
}
