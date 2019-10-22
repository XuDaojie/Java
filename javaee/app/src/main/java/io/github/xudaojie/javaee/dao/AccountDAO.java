package io.github.xudaojie.javaee.dao;

import io.github.xudaojie.javaee.bean.AccountBean;

/**
 * Created by xdj on 2017/4/2.
 */
public interface AccountDAO {
    AccountBean getAccount(String username);

    boolean addAccount(AccountBean accountBean);
}
