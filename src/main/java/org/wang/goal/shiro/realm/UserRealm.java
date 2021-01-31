package org.wang.goal.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.wang.goal.domain.Role;
import org.wang.goal.domain.User;
import org.wang.goal.service.IUserService;
import org.wang.goal.utils.ApplicationContextUtil;

public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        IUserService userService = (IUserService) ApplicationContextUtil.getBean("userServiceImpl");

        User<Role> user=userService.selectRolesByEmail(primaryPrincipal);

        System.out.println(primaryPrincipal+"==========================授权==============================");
        //授权角色信息
        if(user!=null){
            SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
            for (Role role:user.getData()) {
                simpleAuthorizationInfo.addRole(role.getName());
            }
            return simpleAuthorizationInfo;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String principal=(String) authenticationToken.getPrincipal();
        
        IUserService userService = (IUserService) ApplicationContextUtil.getBean("userServiceImpl");

        System.out.println("认证==============================");

        User user = userService.selectUserByEmail(principal);

        if(user!=null){
            return new SimpleAuthenticationInfo(user.getEmail(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }

        return null;
    }
}
