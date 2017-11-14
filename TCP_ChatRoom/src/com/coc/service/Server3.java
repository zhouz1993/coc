package com.coc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务端应用程序
 */
public class Server3 {
	// 服务端Socket
	private ServerSocket serverSocket;
	 // 所有客户端输出流
	private List<PrintWriter> allOut;
	
	/**
     * 构造方法，用于初始化
     */
	public Server3(){
		try {
			serverSocket = new ServerSocket(8088);
			allOut = new ArrayList<PrintWriter>();
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
			
			//启动一个线程来完成针对该客户端的交互
			ClientHandler handler = new ClientHandler(socket);
			new Thread(handler).start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args){
		Server3 server = new Server3();
		server.start();
	}
	
	/**
	 * 线程体，用于并发处理不同客户端的交互
	 * @author Administrator
	 *
	 */
	
	private class ClientHandler implements Runnable{
		private Socket socket;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				//将客户端的输出流存入共享集合，以便广播消息
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
				pw = new PrintWriter(osw,true);
				/*
                 * 将用户信息存入共享集合
                 */
				allOut.add(pw);
				
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String message = null;
				//循环读取客户端发送的信息
				while((message = br.readLine()) != null){
					/*
                     * 遍历所有输出流，将该客户端发送的信息转发给所有客户端
                     */
				//	System.out.println(socket.getInetAddress()+" : "+br.readLine());
					for(PrintWriter o : allOut){
						o.println(socket.getInetAddress()+" : "+message);
					}
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				/*
                 * 当客户端断线，要将输出流从共享集合中删除
                 */
				allOut.remove(pw);
				if(socket != null){
					try {
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
}








