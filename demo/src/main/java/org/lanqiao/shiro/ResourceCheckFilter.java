package org.lanqiao.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.lanqiao.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shiro自定义过滤器，用来判断某一个Url是否属于当前用户的权限
 * 
 * @author songzt@lanqiao.org
 *
 */
public class ResourceCheckFilter extends AuthorizationFilter {
	private final static Logger loger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 表示是否允许访问，如果允许访问返回true,否则返回false
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = getSubject(request, response);
		//  /user/list
		String url = getPathWithinApplication(request);
		//判断是否有权限
		boolean bool  =subject.isPermitted(url);
		loger.debug("ResourceCheckFilter  found url is  [{}] , Permit  is {} ", url,bool);
		return  bool;
	}


}
