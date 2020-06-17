package io.github.xudaojie.springframework.common.service;

import io.github.xudaojie.springframework.common.AccountBean;

public interface AccountService {

    AccountBean selectAccount(long id);

    AccountBean selectAccount(String username);

    int insertAccount(AccountBean accountBean);

    int insert2Account(AccountBean accountBean1, AccountBean accountBean2);

    int del(long id);

    int update(String username, String password);
}
