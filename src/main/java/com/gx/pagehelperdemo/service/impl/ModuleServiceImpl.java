package com.gx.pagehelperdemo.service.impl;

import com.gx.pagehelperdemo.common.base.service.impl.BaseServiceImpl;
import com.gx.pagehelperdemo.entity.Module;
import com.gx.pagehelperdemo.mapper.ModuleMapper;
import com.gx.pagehelperdemo.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl extends BaseServiceImpl<Module> implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public List<Module> findListByIds(List<Integer> ids) {
        return moduleMapper.findListByIds(ids);
    }
}
