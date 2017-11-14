package com.coc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端应用程序
 */
public class Server {
	
	private ServerSocket serverSocket;
	/**
     * 构造方法，用于初始化
     */
	public Server(){
		try {
			serverSocket = new ServerSocket(8088);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 /**
     * 服务端开启方法
     */
	public void start(){
		try {
			System.out.println("等待客户端连接...");
			//监听客户端的连接
			Socket socket = serverSocket.accept();
			System.out.println(socket);
			System.out.println("客户端已连接!");
			
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
		//	System.out.println("客户端说:"+br.readLine());
			
			//  ----- v2 ---start
			while(true){
				System.out.println("客户端说"+ socket.getInetAddress() +":"+br.readLine());
			}
		    //  ----- v2 ---- end
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args){
		Server server = new Server();
		server.start();
	}
	
	
}








