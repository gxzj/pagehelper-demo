package com.gx.pagehelperdemo.dto;

import com.gx.pagehelperdemo.entity.RoleInfo;
import com.gx.pagehelperdemo.entity.UserInfo;

/**
 * 数据传输层，字段只允许写类对象
 */
public class UserDto {
    private UserInfo userInfo;
    private RoleInfo roleInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }
}
