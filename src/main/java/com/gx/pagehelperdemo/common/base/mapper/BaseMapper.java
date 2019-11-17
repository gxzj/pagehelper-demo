package com.gx.pagehelperdemo.common.base.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 通用mapper接口
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>,InsertListMapper<T> {

}
