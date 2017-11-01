package org.lanqiao.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.RandomAccess;

import com.mysql.jdbc.Buffer;



/**
 * IO   方向   输入和输出      字节 和字符
 * 抽象类
 * InputStream 
 * OutputStream 
 * Reader Writer  
 * 前缀加一个File
 * 
 * InputStreamReader      转换流    字符流                   键盘的输入输出和网络的输入输出
 * 
 * 
 * @author Administrator
 *
 */
public class Test4  implements  Serializable {
	

	/**
	 * 使用递归遍历文件和文件目录
	 * @param file
	 */
	public  static  void  listFile(File file){
		if(file!=null){
			if(file.isDirectory()){
				File [] files =file.listFiles();
				for(int i =0;file!=null &&files.length>0 &&i<files.length ;i++){
					listFile(files[i]);
				}
			}else{
				System.out.println(file.getAbsolutePath());
			}
			
		}
		
	}

	public static void main(String[] args) {

		try {
			RandomAccessFile   accessFile=new RandomAccessFile("D:\\pp.txt", "r");
			try {
				accessFile.skipBytes(10);
				String s =accessFile.readLine();
				System.out.println(s);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					accessFile.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
