package org.lanqiao.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	private final  static  Logger loger = LoggerFactory.getLogger(UserController.class);

	
	@RequestMapping("/ajax/cors")
	@ResponseBody
	public Object ajaxCors(HttpServletResponse response){
		loger.debug("ajaxCors请求进来了----------------------------------");
		HashMap map =new HashMap();
		map.put("meg", "ok");
		map.put("code", "250");
		response.setHeader("Access-Control-Allow-Origin","*"); //*代表可访问的地址，可以设置指定域名
		response.setHeader("Access-Control-Allow-Methods",":POST,GET"); 
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
		return map;
	}
	
	
	
	@RequestMapping("/ajax/jsonp")
	@ResponseBody
	public Object ajaxJsonp( @RequestParam("jsonpcallback")  String jsonp){
		loger.debug("ajaxJsonp请求进来了----------------------------------"+jsonp);
	
		return jsonp+"({msg:'OK1111',code:'250'})";
	}
}
