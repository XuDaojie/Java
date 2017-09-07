package com.xdj.springboot.mapper;

import com.xdj.springboot.du.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") Integer id);

    @Select("select * from user")
    List<User> findUser();
}
