package com.coc.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * 客户端应用程序
 * 第一步:实现向服务器发送一条信息
*/
public class Client {
	//客户端Socket
	private Socket socket;
	/**
     * 构造方法，用于初始化
     */
	public Client(){
		try {
			socket = new Socket("localhost",8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 客户端工作方法
     */
	public void start(){
		
		try {
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw = new PrintWriter(osw,true);
		//	pw.println("hello Server");
			
			// ----- v2 ---start
			Scanner scanner = new Scanner(System.in);
			while(true){
				pw.println(scanner.nextLine());
			}
			// ----- v2 ----end
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
	
}
