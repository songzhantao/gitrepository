package org.lanqiao.controller.admin;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import java.util.concurrent.FutureTask;

public class Test3 {

	public static void main(String[] args) {
		Task3  task3=new Task3(); //创建一个子任务
		FutureTask<BigDecimal>  mainTask=new  FutureTask<BigDecimal>(task3);
		Thread t  =new Thread(mainTask);
		t.start();
		try {
			BigDecimal   v  =mainTask.get();
			System.out.println(v.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}



class Tasko extends   Thread{
	
	@Override
	public void run() {

	
	}
	
}

class  Task1  implements  Runnable{

	@Override
	public void run() {
		
	}
	
	
}

//第三种方式，解决了线程的返回值问题 
//BigInteger  大整数
//BigDecimal  大浮点数

class Task3   implements  Callable<BigDecimal>{

	@Override
	public BigDecimal call() throws Exception {
		BigDecimal t =null; 
		BigDecimal result =new BigDecimal(5); 
		
		
		for(int i =1;i<100;i++){
			t=new BigDecimal(i);
			result =result.multiply(t);
		}
		return result;
	}
	
}



//第四种，线程池














