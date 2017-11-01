package org.lanqiao.test;

public class Teste {

	public static void main(String[] args) {
		
		SumThread  t1 =new SumThread();
		SumThread  t2 =new SumThread();
		SumThread  t3 =new SumThread();
		SumThread  t4 =new SumThread();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		try {
			t1.join();  //把线程 t1 加入到此当前线程（main）中，执行
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int result =SumThread.get();
		System.out.println(result);
		
	}
}




class  SumThread extends   Thread{
	
	static  int  s =0;
	static int  p =1;
	
	@Override
	public void run() {
		sum();
	}
	
	public static int  get(){
		return  s;
	}
	
	public synchronized void   sum(){
		int i =0;
		while(i<25){
			s=s+p;
			p++;
			
			i++;
			
		}
		
	}
	
	
}



