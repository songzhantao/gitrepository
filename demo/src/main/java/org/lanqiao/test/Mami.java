package org.lanqiao.test;


//静态代理类  
public class Mami  implements Girl{

	Girl  gril ;
	
	public  Mami(Girl  gril){
		this.gril=gril;
	}
	

	@Override
	public void service() {
		for(int i =0;i<3;i++){
			gril.service();
			
		}
			
	}
	
	//增强了一个方法
	public void   togeherService(){
		gril.service();
		gril.service();
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Thread  t =new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("A");
			}
			
		};
		t.start();
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("B");
		
	}

	
	
}
