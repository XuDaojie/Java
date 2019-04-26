package io.github.xudaojie.templates.generator;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Assert;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Resource;

public class BaseServiceImpl<D extends BaseDataSource<T>, T> implements BaseService<T> {

    @Resource
    protected D baseDataSource;

    @Override
    public boolean save(T entity) {
        return baseDataSource.save(entity);
    }

    /**
     * 批量插入
     *
     * @param entityList ignore
     * @param batchSize ignore
     * @return ignore
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        return baseDataSource.saveBatch(entityList, batchSize);
    }

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param entity 实体对象
     * @return boolean
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOrUpdate(T entity) {
        return baseDataSource.saveOrUpdate(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return baseDataSource.saveOrUpdateBatch(entityList, batchSize);
    }

    @Override
    public boolean removeById(Serializable id) {
        return baseDataSource.removeById(id);
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        Assert.notEmpty(columnMap, "error: columnMap must not be empty");
        return baseDataSource.removeByMap(columnMap);
    }

    @Override
    public boolean remove(Wrapper<T> wrapper) {
        return baseDataSource.remove(wrapper);
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return baseDataSource.removeByIds(idList);
    }

    @Override
    public boolean updateById(T entity) {
        return baseDataSource.updateById(entity);
    }

    @Override
    public boolean update(T entity, Wrapper<T> updateWrapper) {
        return baseDataSource.update(entity, updateWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        Assert.notEmpty(entityList, "error: entityList must not be empty");
        return baseDataSource.updateBatchById(entityList, batchSize);
    }

    @Override
    public T getById(Serializable id) {
        return baseDataSource.getById(id);
    }

    @Override
    public Collection<T> listByIds(Collection<? extends Serializable> idList) {
        return baseDataSource.listByIds(idList);
    }

    @Override
    public Collection<T> listByMap(Map<String, Object> columnMap) {
        return baseDataSource.listByMap(columnMap);
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
        return baseDataSource.getOne(queryWrapper, throwEx);
    }

    @Override
    public Map<String, Object> getMap(Wrapper<T> queryWrapper) {
        return baseDataSource.getMap(queryWrapper);
    }

    @Override
    public int count(Wrapper<T> queryWrapper) {
        return baseDataSource.count(queryWrapper);
    }

    @Override
    public List<T> list(Wrapper<T> queryWrapper) {
        return baseDataSource.list(queryWrapper);
    }

    @Override
    public IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper) {
        return baseDataSource.page(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper) {
        return baseDataSource.listMaps(queryWrapper);
    }

    @Override
    public <V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return baseDataSource.listObjs(queryWrapper).stream().filter(Objects::nonNull).map(mapper).collect(Collectors.toList());
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper) {
        return baseDataSource.pageMaps(page, queryWrapper);
    }
}
