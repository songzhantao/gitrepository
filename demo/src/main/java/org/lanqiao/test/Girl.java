package org.lanqiao.test;


//红尘女子
public interface Girl {
	//按摩
	public  void  service();  

	
	
}

class Juhua implements Girl {

	//AOP
	@Override
	public void service() {
		
		System.out.println("菊花正在为人民服务");
		
	}
	
	
}


class LongGirl implements Girl{

	@Override
	public void service() {
		System.out.println("龙女正在为人民服务");
		
	}
	
	
}


