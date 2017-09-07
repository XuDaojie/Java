package com.xdj.springboot.mapper;

import com.xdj.springboot.du.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapperTk extends BaseMapper<User> {

    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") Integer id);

    @Select("select * from user")
    List<User> findUser();
}
