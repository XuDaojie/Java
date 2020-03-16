package io.github.xudaojie.mybatis.mapper;

import io.github.xudaojie.mybatis.bean.GoodsBean;

public interface GoodsMapper {

    GoodsBean findById(Long id);
}
