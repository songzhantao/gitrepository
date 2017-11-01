package org.lanqiao.test;

import java.util.HashMap;

public class Testmain {

	
	//当前线程睡眠多长时间，此时其他线程不能进来执行
	public  synchronized  void  test1(){
		try {
			// 有限等待状态，线程不会释放排他锁  
			if(Thread.currentThread().getName().equals("A")){
				Thread.sleep(5000);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"正在执行test1");
		
		HashMap map;
	}
	
	
	public  synchronized  void  test2(){
		
		try {
			//当前线程进入无限等待状态，  等待其他线程唤醒  notify  notifyall  且让出排除锁 
			if(Thread.currentThread().getName().equals("A")){
				this.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"正在执行test2");
		
		
	}
	
	
	public static void main(String[] args) {
		final Testmain  main=new Testmain();
		Thread  t =new Thread(){
			@Override
			public void run() {
				main.test2();
			}
			
		};
		t.setName("A");
		t.start();
		
		
		Thread  t2 =new Thread(){
			@Override
			public void run() {
				main.test2();
			}
			
		};
		t2.setName("B");
		t2.start();
	}
	
}
