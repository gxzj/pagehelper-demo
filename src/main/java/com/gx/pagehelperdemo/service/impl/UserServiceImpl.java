package com.gx.pagehelperdemo.service.impl;

import com.gx.pagehelperdemo.common.base.service.impl.BaseServiceImpl;
import com.gx.pagehelperdemo.common.exception.CustomerException;
import com.gx.pagehelperdemo.entity.UserInfo;
import com.gx.pagehelperdemo.mapper.UserInfoMapper;
import com.gx.pagehelperdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserInfo> implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findUserByAccount(String userAccount) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAccount(userAccount);
        return findModelOne(userInfo);
    }

    @Override
    public void testBaseException() {
        //...
        throw new CustomerException("抛出业务异常");
        //throw new RuntimeException("抛出RuntimeException异常");
    }

}
