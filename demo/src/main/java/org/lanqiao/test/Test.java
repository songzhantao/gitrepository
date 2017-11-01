package org.lanqiao.test;

public class Test {

	public static void main(String[] args) {
		final  int l=10;
		int [] nums ={1,2,3,4,5,6,7,8,9,10};
		int c=0;
		
		for(int i=10;i>0;i--){
		   int r =(int)(Math.floor((Math.random()*i)));
		   System.out.println("随机数:"+nums[r]);
		   int temp=nums[i-1];
		   nums[i-1]=nums[r];
		   nums[r]=temp;
		    
		}
				
		
	}
}
