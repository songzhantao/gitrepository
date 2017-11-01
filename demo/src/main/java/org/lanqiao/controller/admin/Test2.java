package org.lanqiao.controller.admin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * @author 获取方法区的类型信息，是通过获取类型信息在方法区的映射对象Class来操作的。 Class对象就反射的入口.
 * 一如何获取Class对象，   三四中方式:
 * 1、  类名.class     实例对象的getClass   还有 Class.forname    数据类型包装类的.type2
 * 2、 动态的调用，方法 、属性  甚至是注解 和构造方法
 * 
 *
 */
public class Test2 {

	String name;
	Integer age;
	
	private  String id;
	
	public void setName(String value){
		this.name=value;
	}
	
	
	
	@Deprecated
	public void  print(){
		System.out.println("print.........。。。。");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class   clazz = Test2.class;
		Test2  t2=new  Test2();
		Class  clazz2  =t2.getClass();
		Class clazz3 =Class.forName("org.lanqiao.controller.admin.Test2");
		
		Class cz = Integer.TYPE;
		//创建一个实例
		Object   obj  =	clazz3.newInstance();
	
		//我想知道Test里面有哪些方法
		Method []  ms  =clazz3.getDeclaredMethods();
		for(Method m:ms){
			//System.out.println(m.getName());
			Annotation  an =	m.getAnnotation(java.lang.Deprecated.class);
			if(an==null){
				System.out.println(m.getName() +"头顶上没有注解");
			}
			if(!"main".equals(m.getName())){
				try {
					//调用print方法
					m.invoke(obj, null);
					m.invoke(obj, null);
					m.invoke(obj, null);
				} catch (IllegalArgumentException e) {
					
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		Field  []  fs = clazz3.getDeclaredFields();
		//clazz3.getField();  public
		for(Field  f :fs){
			System.out.println(f.getName());
		}
		
		
		//
		
	}
}
