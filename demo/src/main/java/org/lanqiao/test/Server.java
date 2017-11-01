package org.lanqiao.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket  serverSocket=null;
		try {
			serverSocket  =new  ServerSocket(10000);
			Socket  socket  =serverSocket.accept();
			System.out.println("来个人");
			OutputStream  os =	socket.getOutputStream();
			BufferedWriter  bf =new BufferedWriter(new OutputStreamWriter(os));
			bf.write("恭喜你 登录成功，欢迎来到蓝桥聊天式");
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			/*try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
		
		
	}
}
