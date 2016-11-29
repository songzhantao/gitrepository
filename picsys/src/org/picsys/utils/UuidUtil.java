package org.picsys.utils;
import java.util.UUID;

/**
 * 订单UUID生成工具类
  * @desc: TODO
  * @author songzhantao
  * @date 2016年9月2日 下午3:04:29
 */
public class UuidUtil {
	/**
	 * 随机一个32位的UUID
	 * @return
	 */
	public  static String getId(){
	/*	Date date=new Date();
		double d =Math.random()*10000000;
		String strDate=String.valueOf(date.getTime()+Math.floor(d));*/
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
}
