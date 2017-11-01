package org.lanqiao.test;
//快速排序
public class QuikSort {
	
	
	public static void main(String [] args){
		 int   []list ={5,4,100,8,9};
		 QuikSort.quiksort(list, 0, list.length-1);
		 
		 for(int i =0;i<list.length;i++){
			 System.out.println(list[i]);
			 
		 }
		 
	}
	
	
	/**
	 * 核心排序算法 ，使用地柜完成
	 * @param low  从左方向 
	 * @param high
	 */
	public static void quiksort( int [] list , int low ,int high){
		 int  i , j , pointer;
		 //递归终止条件
		 if(low >high){
			 return;
		 }
		 //基准
		 pointer  =  list[low];
		 i=low;
		 j=high;
		 
		 while(i<j){
			 //从右边到左边          
			 while(list[j]>pointer &&  i<j){
				 j--;
			 }
			 list[i]=list[j];
			 //从左边到右边
			 while(list[i]<pointer &&  i<j){
				 i++;
			 }
			 list[j]=list[i];
			 
		 }
		 list[j]=pointer;
	
		quiksort(list,low,j-1);//继续处理左边的，这里是一个递归的过程 
		quiksort(list ,i+1,high);//继续处理右边的 ，这里是一个递归的过程 
		 
	}
	
}
