package com.xdj.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdj.springboot.du.User;
import com.xdj.springboot.mapper.UserMapper;
import com.xdj.springboot.mapper.UserMapperTk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapperTk userMapperTk;

    @RequestMapping("/user/{id}")
    public User user(@PathVariable("id") Integer userId) {
        return userMapper.findUserById(userId);
    }

    @RequestMapping("/user")
    public PageInfo<User> user() {
        PageHelper.startPage(0, 10);
        PageInfo<User> userPageInfo = new PageInfo<>(userMapper.findUser());
        return userPageInfo;
    }

    @RequestMapping("/user/tk")
    public PageInfo<User> userTk() {
        PageHelper.startPage(0, 10);
        PageInfo<User> userPageInfo = new PageInfo<>(userMapperTk.selectAll());
        return userPageInfo;
    }
}
