package com.gx.pagehelperdemo.common.base.service.impl;

import com.gx.pagehelperdemo.common.base.mapper.BaseMapper;
import com.gx.pagehelperdemo.common.base.service.BaseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 通用service实现类
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public T findModelById(int id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public T findModelOne(T t) {
        return baseMapper.selectOne(t);
    }

    @Override
    public List<T> findByExample(Object example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int findCountByExample(Object example) {
        return baseMapper.selectCountByExample(example);
    }

    @Override
    public List<T> findListByModel(T t) {
        return baseMapper.select(t);
    }

    @Override
    public List<T> findListByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return baseMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public List<T> findListByRowBounds(T record, RowBounds rowBounds) {
        return baseMapper.selectByRowBounds(record, rowBounds);
    }

    @Override
    public int findCountByModel(T t) {
        return baseMapper.selectCount(t);
    }

    @Override
    public List<T> findAll() {
        return baseMapper.selectAll();
    }

    @Override
    public int insertModel(T t) {
        return baseMapper.insertSelective(t);
    }

    @Override
    public int insertModelList(List<T> list) {
        return baseMapper.insertList(list);
    }

    @Override
    public int updateModel(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByExample(T record, Object example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int deleteById(int id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(Object example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByModel(T t) {
        return baseMapper.delete(t);
    }

    @Override
    public int deleteByIdList(List<Integer> idlist) {
        return 0;
    }

}
