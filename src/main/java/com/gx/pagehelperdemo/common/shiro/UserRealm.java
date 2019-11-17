package com.gx.pagehelperdemo.common.shiro;

import com.gx.pagehelperdemo.common.CommonConstant;
import com.gx.pagehelperdemo.entity.Authority;
import com.gx.pagehelperdemo.entity.Module;
import com.gx.pagehelperdemo.entity.RoleInfo;
import com.gx.pagehelperdemo.entity.UserInfo;
import com.gx.pagehelperdemo.service.AuthorityService;
import com.gx.pagehelperdemo.service.ModuleService;
import com.gx.pagehelperdemo.service.RoleService;
import com.gx.pagehelperdemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro安全验证
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private ModuleService moduleService;

    /**
     * 提供用户信息，返回权限信息
     * @param principals
     * @return 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userName = (String) principals.getPrimaryPrincipal();
        UserInfo user = userService.findUserByAccount(userName); //用户名称
        int froleid = user.getRoleid(); //角色ID
        RoleInfo ri = new RoleInfo();
        ri.setRoleid(froleid);
        RoleInfo froleInfo = roleService.findModelOne(ri); //通过角色ID查询角色
        Set<String> roleSet = new HashSet<>();
        roleSet.add(froleInfo.getRoleName()); //一个用户一个角色
        Example example = new Example(Authority.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid", froleid); //ID查询
        List<Authority> authoritySet = authorityService.findByExample(example); //通过角色ID查询权限信息
        List<Integer> ids = new ArrayList<>();//ids查询模块名称
        for (Authority authority : authoritySet) {
            ids.add(authority.getModuleid()); //添加权限名称
        }
        List<Module> moduleSet = moduleService.findListByIds(ids); //查询ids权限名称
        Set<String> pemissionSet = new HashSet<>(); //权限名称集合
        for (Module module : moduleSet) {
            pemissionSet.add(module.getModuleName()); //添加权限名称
        }
        // 将角色名称组成的Set提供给授权info
        authorizationInfo.setRoles(roleSet);
        // 将权限名称组成的Set提供给info
        authorizationInfo.setStringPermissions(pemissionSet);
        return authorizationInfo;
    }

    /**
     * 提供帐户信息，返回认证信息
     * @param authenticationToken
     * @return 认证信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        UserInfo user = userService.findUserByAccount(userName);
        if (user == null) {
            //用户不存在就抛出异常
            throw new UnknownAccountException();
        }
        if (CommonConstant.USER_LOCK==(user.getIsused()==true?1:0)) {
            //用户被锁定就抛异常
            throw new LockedAccountException();
        }
        //密码可以通过SimpleHash加密，然后保存进数据库。
        //此处是获取数据库内的账号、密码、盐值，保存到登陆信息info中
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserAccount(),
                user.getUserPassword(),
                ByteSource.Util.bytes(user.getSalt()), //盐
                getName()); //realm name
        return authenticationInfo;
    }
}
