package io.github.xudaojie.templates.generator.data;

import io.github.xudaojie.templates.generator.BaseRepository;
import io.github.xudaojie.templates.generator.data.mapper.UserMapper;
import io.github.xudaojie.templates.generator.domain.User;

/**
 * <p>
 * 用户数据源
 * </p>
 *
 * @author xdj
 * @since 2019-04-25
 */
public class UserRepository extends BaseRepository<UserMapper, User> implements UserDataSource {
}
