package com.xdj.javaee.dao;

import com.xdj.javaee.bean.AccountBean;

/**
 * Created by xdj on 2017/4/2.
 */
public interface AccountDAO {
    AccountBean getAccount(String username);

    boolean addAccount(AccountBean accountBean);
}
