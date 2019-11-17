package com.gx.pagehelperdemo.service;

import com.gx.pagehelperdemo.common.base.service.BaseService;
import com.gx.pagehelperdemo.entity.Module;

import java.util.List;

public interface ModuleService extends BaseService<Module> {

    List<Module> findListByIds(List<Integer> ids);

}
