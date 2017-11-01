package org.lanqiao.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

class Student{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	String name;
	String age;
	String  birthday;
	
	
	
}




public class Ttest {

	public static void main(String[] args) {
		Student student =new Student();
		Class clazz =Student.class;
		Method []  ms  =  clazz.getDeclaredMethods();
		
		String  str="#name:zhagnsan;#age:25;#birthday:1988/10/10";
		String []  ars  =str.split(";");
		for(String obj:ars){
			String   val = obj.substring(1);			
			String []  obs =  val.split(":");
			System.out.println("property :"+obs[0]);
			System.out.println("value:"+obs[1]);
			for(Method m:ms){
				if(m.getName().equals("set"+(obs[0].substring(0,1).toUpperCase())+obs[0].substring(1))){
					try {
						m.invoke(student, obs[1]);
					} catch (Exception e) {
						e.printStackTrace();
					} 
					
				}
			}
			
		}
		
		
		System.out.println(student.getAge());
		
		
		
		
	}
}



















