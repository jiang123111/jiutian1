package com.jiutian.jiutian.shiro;

import com.jiutian.jiutian.entity.Admin;
import com.jiutian.jiutian.mapper.AdminMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component //Spring IOC创建对象
public class MyRealm extends AuthorizingRealm {
    //1、授权  查询登录用户的角色或者权限
    @Autowired
    AdminMapper adminMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //1、获取登录用户
        Admin admin=(Admin) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        //2、查询当前用户的所有权限
        List<String> perms=adminMapper.selectPerms(admin.getId());
        //3、实例化授权对象
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //4、赋值
        authorizationInfo.addStringPermissions(perms);

        return authorizationInfo;
    }
    //2、认证 生成凭证 登录成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;

        if(token.getUsername()!=null){
            //登录成功
            AuthenticationInfo info=new SimpleAuthenticationInfo(token.getPrincipal(),token.getPassword(),getName());
            return info;
        }

        return null;
    }
}
