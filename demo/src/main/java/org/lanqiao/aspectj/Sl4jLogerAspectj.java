package org.lanqiao.aspectj;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 	切面类   切点:每一个方法
 * @author
 *
 */
public class Sl4jLogerAspectj {
	Logger loger  =LoggerFactory.getLogger(Sl4jLogerAspectj.class);
	
	//之前
	public void sl4Jbefore(){
		loger.debug("SpringAOP 进来了");
	}
	
	//之后
	public void sl4Jafter(){
		loger.debug("SpringAOP 出去了");
	}
	
}
