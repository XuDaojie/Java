package ${package.Controller};


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

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
@RequestMapping("/${table.entityPath}s")
public class UserController {
    <#assign serviceField="${table.entityPath}Service">

    @Resource
    private ${table.serviceName} ${table.entityPath}Service;

    /**
     *
     * @param id ignore
     * @return 根据id返回数据
     */
    @GetMapping("/{id}")
    public ${entity} findById(@PathVariable String id) {
        return ${serviceField}.getById(id);
    }

    /**
     * 根据id返回列表
     * @param ids id集合 格式: id1,id2,id3
     * @return
     */
    @GetMapping("/batch/{ids}")
    public Collection<${entity}> findByIds(@PathVariable List<String> ids) {
        return ${serviceField}.listByIds(ids);
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
        return ${serviceField}.save(user);
    }

    /**
     * 批量新增记录
     * @param users
     * @return
     */
    @PostMapping("/batch")
    public boolean saveBatch(@RequestBody List<${entity}> users) {
        return ${serviceField}.saveBatch(users);
    }

    /**
     * 根据id更新一条记录
     * @param user
     * @return
     */
    @PutMapping("")
    public boolean updateById(@RequestBody ${entity} user) {
        return ${serviceField}.updateById(user);
    }

    /**
     * 根据id批量更新记录
     * @param user
     * @return
     */
    @PutMapping("/batch")
    public boolean updateBatchById(@RequestBody List<${entity}> user) {
        return ${serviceField}.updateBatchById(user);
    }

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean removeById(@PathVariable String id) {
        return ${serviceField}.removeById(id);
    }

    /**
     * 根据id批量删除记录
     * @param ids id集合 格式: id1,id2,id3
     * @return
     */
    @DeleteMapping("/batch/{ids}")
    public boolean removeByIds(@PathVariable List<String> ids) {
        return ${serviceField}.removeByIds(ids);
    }

}

