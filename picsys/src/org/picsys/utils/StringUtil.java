package org.picsys.utils;

/**
 * �ַ���������
  * @desc: TODO
  * @author songzhantao
  * @date 2016��9��1�� ����2:54:49
 */
public class StringUtil {

	
	/**
	 * �Ѷ���ת����String������ַ�����null ��ת���""
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
