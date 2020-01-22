package com.nzh.config;

import com.nzh.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @author 倪志浩
 * @program springboot-shiro
 * @packageName com.nzh.config
 * @ClassName ShiroRealm
 * @description
 * @create 2020-01-22
 * @Version 1.0
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权认证");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了身份认证");
        String name="root";
        String password = "123456";
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        if (!userToken.getUsername().equals(name)){
            return null;
        }
        User user = new User();
        user.setName("root");
        user.setPassword("123456");
        user.setPerms("user:add");
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
