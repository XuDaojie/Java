package io.github.xudaojie.generator.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import io.github.xudaojie.generator.domain.User;
import io.github.xudaojie.generator.service.UserService;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xdj
 * @since 2019-04-25
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    /**
     *
     * @param id ignore
     * @return 根据id返回数据
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.getById(id);
    }

    /**
     * 根据id返回列表
     * @param ids id集合 格式: id1,id2,id3
     * @return
     */
    @GetMapping("/batch/{ids}")
    public Collection<User> findByIds(@PathVariable List<String> ids) {
        return userService.listByIds(ids);
    }

//    /**
//     * 根据条件查询
//     * @param ids
//     * @return
//     */
//    @GetMapping("")
//    public String findByWrapper(List<String> ids) {
//        return null;
//    }

    /**
     * 新增一条记录
     * @param user
     * @return
     */
    @PostMapping("")
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * 批量新增记录
     * @param users
     * @return
     */
    @PostMapping("/batch")
    public boolean saveBatch(@RequestBody List<User> users) {
        return userService.saveBatch(users);
    }

    /**
     * 根据id更新一条记录
     * @param user
     * @return
     */
    @PutMapping("")
    public boolean updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    /**
     * 根据id批量更新记录
     * @param user
     * @return
     */
    @PutMapping("/batch")
    public boolean updateBatchById(@RequestBody List<User> user) {
        return userService.updateBatchById(user);
    }

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean removeById(@PathVariable String id) {
        return userService.removeById(id);
    }

    /**
     * 根据id批量删除记录
     * @param ids id集合 格式: id1,id2,id3
     * @return
     */
    @DeleteMapping("/batch/{ids}")
    public boolean removeByIds(@PathVariable List<String> ids) {
        return userService.removeByIds(ids);
    }

}

