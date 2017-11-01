package org.lanqiao.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class A {
		
	public static void main(String[] args) {
	  HashMap<String,Object> maps =new HashMap<String,Object>(30);
	  Hashtable   table =new Hashtable();
	  java.util.concurrent.ConcurrentHashMap<String, Object>  map =new  ConcurrentHashMap<String,Object>();
	  
	  TreeMap<Object ,Object>  map2=new TreeMap<Object ,Object>();
	  map2.put(new AA(), "abc");
	  map2.put(new AA(), "abc2");
	  
	  
	  
	  ArrayList<BB> list =new ArrayList();
	  list.add(new BB());
	  list.add(new BB());
	  list.add(new BB());
	  
	  //外部比较器
	  Collections.sort(list, new  Comparator<BB>() {

		@Override
		public int compare(BB o1, BB o2) {
			return  o1.age.compareTo(o2.age);
		}
	});
	  
	
	}
}


class Node{
	Object value;
	Node pre;
	Node next;
	
}
class BB{
	Integer age;
	
}

//内部比较器
class   AA  implements Comparable<AA>{

	@Override
	public int compareTo(AA o) {
		
		return 0;
	}
	
}

