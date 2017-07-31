package com.giit.www.realm;

import com.giit.www.entity.User;
import com.giit.www.system.service.UserBiz;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * 
 * @author Nocol
 * 
 * 自定义realm
 *
 */
public class UserRealm extends AuthorizingRealm {

    @Resource(name="userBizImpl")
    private UserBiz userBiz;
    
    /**
     * 用户授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	//获取的用户名为已经认证过的
        String username = (String)principals.getPrimaryPrincipal();
        
        //创建授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //为该用户赋予角色
        authorizationInfo.setRoles(userBiz.findRoles(username));
        //为该角色赋予权限
        authorizationInfo.setStringPermissions(userBiz.findPermissions(username));
        //返回授权信息
        return authorizationInfo;
    }
    
    /**
     * 用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        
        User user = userBiz.findById(username);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserId(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm 的名称
        );
        //返回认证信息
        return authenticationInfo;
    }


}
