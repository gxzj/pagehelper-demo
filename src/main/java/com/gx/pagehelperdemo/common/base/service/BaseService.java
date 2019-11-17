package com.gx.pagehelperdemo.common.base.service;

import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 通用service接口
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 查询一行数据通过ID
     * @param id
     * @return
     */
    T findModelById(int id);

    /**
     * 查询一行数据通过名称
     * @param t
     * @return
     */
    T findModelOne(T t);

    /**
     * 根据Example条件进行查询
     * @param example
     * @return
     */
    List<T> findByExample(Object example);

    /**
     * 获取根据Example条件进行查询的数据数量
     * @param example
     * @return
     */
    int findCountByExample(Object example);

    /**
     * 通过实体字段值不为空查询数据
     * @param t
     * @return
     */
    List<T> findListByModel(T t);

    /**
     * 通过实体字段值不为空查询数据数量
     * @param t
     * @return
     */
    int findCountByModel(T t);

    /**
     * 通过ExampleAndRowBounds查询数据
     * @param example
     * @param rowBounds
     * @return
     */
    List<T> findListByExampleAndRowBounds(Object example, RowBounds rowBounds);

    /**
     * 通过RowBounds查询数据
     * @param record
     * @param rowBounds
     * @return
     */
    List<T> findListByRowBounds(T record, RowBounds rowBounds);

    /**
     * 查询所有数据
     * @return
     */
    List<T> findAll();

    /**
     * 新增一行数据
     * @param t
     * @return
     */
    int insertModel(T t);

    /**
     * 新增多行数据
     * @param list
     * @return
     */
    int insertModelList(List<T> list);

    /**
     * 修改一行数据
     * @param t
     * @return
     */
    int updateModel(T t);

    /**
     * 修改一行数据通过Example条件
     * @param record
     * @param example
     * @return
     */
    int updateByExample(T record, Object example);

    /**
     * 删除一行数据通过ID
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 删除一行数据通过Model
     * @param t
     * @return
     */
    int deleteByModel(T t);

    /**
     * 删除一行数据通过Example条件
     * @param example
     * @return
     */
    int deleteByExample(Object example);

    /**
     * 删除多行数据通过IdList
     * @param idlist
     * @return
     */
    int deleteByIdList(List<Integer> idlist);



}
