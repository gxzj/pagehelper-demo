package com.gx.pagehelperdemo.service;

import com.gx.pagehelperdemo.common.base.service.BaseService;
import com.gx.pagehelperdemo.entity.UserInfo;

public interface UserService extends BaseService<UserInfo> {

    UserInfo findUserByAccount(String userAccount);

    void testBaseException();

}
