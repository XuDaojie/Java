package io.github.xudaojie.springframework.common.dao;

import io.github.xudaojie.springframework.common.AccountBean;

public interface AccountDao {

    AccountBean selectAccount(long id);

    AccountBean selectAccount(String username);

    int insertAccount(AccountBean accountBean);

    int del(long id);

    int update(String username, String password);
}
