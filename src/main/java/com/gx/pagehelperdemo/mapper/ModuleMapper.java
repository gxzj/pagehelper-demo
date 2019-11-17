package com.gx.pagehelperdemo.mapper;

import com.gx.pagehelperdemo.common.base.mapper.BaseMapper;
import com.gx.pagehelperdemo.entity.Module;

import java.util.List;

public interface ModuleMapper extends BaseMapper<Module> {

    List<Module> findListByIds(List<Integer> ids);

}