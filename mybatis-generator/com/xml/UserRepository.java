package io.github.xudaojie.generator.data;

import io.github.xudaojie.templates.generator.BaseRepository;
import io.github.xudaojie.generator.mapper.UserMapper;
import io.github.xudaojie.generator.domain.User;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xdj
 * @since 2019-04-25
 */
public class UserRepository extends BaseRepository<UserMapper, User> implements UserDataSource {
}
