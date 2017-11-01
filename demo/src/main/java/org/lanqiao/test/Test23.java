package org.lanqiao.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class Test23 {

	public static void main(String[] args) {
		LinkedHashMap<String, String>   linkHashMap=new LinkedHashMap<String, String>();
		linkHashMap.put("A", "AAAA");
		linkHashMap.put("B", "AAAA");
		linkHashMap.put("C", "AAAA");
		linkHashMap.put("D", "AAAA");
		linkHashMap.put("E", "AAAA");
		
		for(String  string :linkHashMap.keySet()){
			System.out.println(string);
		}
		
		
		System.out.println("-------------------");
		
		
		
		HashMap<String, String>   hashmap=new HashMap<String, String>();
		
		hashmap.put("A", "AAAA");
		hashmap.put("B", "AAAA");
		hashmap.put("C", "AAAA");
		hashmap.put("D", "AAAA");
		hashmap.put("E", "AAAA");
		for(String  string :hashmap.keySet()){
			System.out.println(string);
		}
		
	}
}
