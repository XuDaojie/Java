package io.github.xudaojie.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import io.github.xudaojie.mybatis.bean.FooBean;

public interface FooMapper {

    FooBean findById(Long id);

    void save(@Param("fooBean") FooBean fooBean);
}
