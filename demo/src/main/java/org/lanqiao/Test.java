package org.lanqiao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;

import com.mysql.jdbc.CallableStatement;

public class Test {

	public Test(){
		
	}
	public static void main() {
		//字面量
		String  str1="hello";
		String str2="he" +new String("llo");
		System.out.println(str1==str2);
		
		String str3 ="he"+"llo";
		System.out.println(str1==str3);
		String  s="java测试";
		try {
			System.out.println(s.getBytes("GBK").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		
		A  a  =new A();
		Test est=new Test();
	}
	
	
	public static class  A extends  Test  {
		
		
		public  A(){
			
		}
	}
	
	
	
	
}
