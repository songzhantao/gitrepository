package org.lanqiao.controller.admin;

import java.io.FileInputStream;
import java.lang.ref.WeakReference;

public class Test {
		A  a=new A();
		WeakReference  weak=new WeakReference(a);
	
	public static void main(String[] args) {
		
	}
}


class A{
	
	
	//GC在回收之前，要调用此方法 ，这个方法，有可能让对象复活，建议不要操作或者重写这个方法
	@Override
	protected void finalize() throws Throwable {
		//引用 
	}
	
}