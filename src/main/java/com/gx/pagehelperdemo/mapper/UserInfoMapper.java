package com.gx.pagehelperdemo.mapper;

import com.gx.pagehelperdemo.common.base.mapper.BaseMapper;
import com.gx.pagehelperdemo.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserInfo> login(@Param("useraccount") String useraccount, @Param("password") String password);

}