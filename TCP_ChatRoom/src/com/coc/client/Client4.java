package com.coc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
public class Client4 {
	//客户端Socket
	private Socket socket;
	/**
     * 构造方法，用于初始化
     */
	public Client4(){
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
			 //将接收服务端信息的线程启动
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.setDaemon(true);
			t.start();
			
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
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Client4 client = new Client4();
		client.start();
	}
	
	private class ServerHandler implements Runnable{

		@Override
		public void run() {
			try {
				
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				while(true){
					System.out.println(br.readLine());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}











