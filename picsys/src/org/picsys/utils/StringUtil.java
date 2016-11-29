package org.picsys.utils;

/**
 * 字符串工具类
  * @desc: TODO
  * @author songzhantao
  * @date 2016年9月1日 下午2:54:49
 */
public class StringUtil {

	
	/**
	 * 把对象转换成String，如果字符串是null 就转变成""
	 * @param string
	 * @return
	 */
	public  static String  toString(Object  string){
		String result="";
		if(string!=null){
			result=	string.toString();		
		}
		return  result;
	}
	
	
}
