package io.github.xudaojie.templates.generator.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import io.github.xudaojie.templates.generator.domain.User;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xdj
 * @since 2019-04-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
