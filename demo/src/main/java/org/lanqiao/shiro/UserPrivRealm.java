package org.lanqiao.shiro;

import java.util.HashSet;

import javax.management.RuntimeErrorException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.lanqiao.model.User;
import org.lanqiao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义的Realm
 * 
 * @author songzt@lanqio.org
 *
 */
public class UserPrivRealm extends AuthorizingRealm {
	Logger logger = LoggerFactory.getLogger(UserPrivRealm.class);

	@Autowired
	UserService userService;

	// 授权 (主要是用来做权限的业务操作和数据库查询)
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.debug("进入 AuthorizationInfo    授权  方法 ");
		//获取用户名
		String  username  =String.valueOf(principals.getPrimaryPrincipal());
		//根据用户名获取角色和权限    List  
		
		
		
		
		// 用来存储当前用户角色集合和权限集合的对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//把List 转换成Set 就可以了 
		//user/list
		HashSet set =new HashSet();
		info.setStringPermissions(set);
		// info.setRoles("");
		// info.setStringPermissions("");
		return info;
	}

	// 身份认证 ( 主要用来做登录的业务操作和数据库查询) 当调用Subject中的login方法之后，调用此方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String uname = String.valueOf(token.getPrincipal());
		String upass = String.valueOf((char[]) token.getCredentials());
		User user =null;
		try{
			user = userService.login(uname, upass);	
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage(),ex.getCause());
		}
		
		if (user == null) {
			throw new IncorrectCredentialsException("用户可能不存在");  //如果用户名错误 
		}
		logger.info("[{}]验证通过,可以登录",uname);
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(uname, upass, getName());
		
		return authenticationInfo;
	}

}
