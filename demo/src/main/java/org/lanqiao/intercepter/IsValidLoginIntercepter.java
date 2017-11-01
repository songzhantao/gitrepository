package org.lanqiao.intercepter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 判断用户是否登录
 * @author SZT
 *
 */
public class IsValidLoginIntercepter implements  HandlerInterceptor {

	Logger  loger = LoggerFactory.getLogger(IsValidLoginIntercepter.class);
	//之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			HttpSession session =request.getSession();
			loger.debug("进入拦截器了---嘿嘿额");
			
			return true;   //false 表示不再继续
	}

	//之后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}
	//视图对象渲染完毕之后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

	
	
}
