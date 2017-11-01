package org.lanqiao.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	
	public static void main(String[] args) {
		
		try {
			Socket socket =new Socket("127.0.0.1",10000);
			BufferedReader  bf =new  BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str =bf.readLine();
			System.out.println(str);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
