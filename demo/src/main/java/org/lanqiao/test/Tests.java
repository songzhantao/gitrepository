package org.lanqiao.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Tests {

	public static void main(String[] args) {
		
		
		PipedInputStream    pis =new PipedInputStream();
		PipedOutputStream   pos =new PipedOutputStream();
		try {
			
			//输入流和输出进行绑定 
			pis.connect(pos);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ATask  a =new ATask(pis);
		BTask  b =new BTask(pos);
		a.start();
		b.start();
		
		
	}
}


class  ATask extends  Thread{
	
	BufferedReader  bf  =null;
	
	public ATask(PipedInputStream   pis){
		bf=new BufferedReader(new InputStreamReader(pis));
		
	}
	@Override
	public void run() {
		//暂停代码
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//读取数据
		try {
			String msg =bf.readLine();
			System.out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//关键
				bf.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		
		
		
		
	
	}
	
}


class  BTask extends  Thread{
	
	BufferedWriter  bw =null;
	
	public BTask(PipedOutputStream   pos){
		bw =	new  BufferedWriter(new OutputStreamWriter(pos));
	}
	
	@Override
	public void run() {
		//暂停代码
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//读取数据
				try {
					bw.write("你好我是另外一个线程，隔壁老王");
					bw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						//关键
						bw.close();
					} catch (IOException e) {
					
						e.printStackTrace();
					}
				}
				
	
	
	}
	
	
	
}


