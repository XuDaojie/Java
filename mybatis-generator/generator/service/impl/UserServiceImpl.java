package io.github.xudaojie.templates.generator.service.impl;

import org.springframework.stereotype.Service;

import io.github.xudaojie.templates.generator.BaseServiceImpl;
import io.github.xudaojie.templates.generator.data.UserDataSource;
import io.github.xudaojie.templates.generator.domain.User;
import io.github.xudaojie.templates.generator.service.UserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xdj
 * @since 2019-04-24
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDataSource, User> implements UserService {
}
