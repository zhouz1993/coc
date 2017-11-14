package com.coc.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server {

	public void start(){
		try {
			//接受客服端的数据
			DatagramSocket server = new DatagramSocket(8088);
			byte[] recvBuf = new byte[100];
			DatagramPacket recvPacket = new DatagramPacket(recvBuf,recvBuf.length);
			server.receive(recvPacket);
			String recvMessage = new String(recvPacket.getData(),0,recvPacket.getLength());
			System.out.println("客户端说:  "+recvMessage);
			
			//向客户端发送数据
			int port = recvPacket.getPort();
			InetAddress addr = recvPacket.getAddress();
			String sendStr = "三十功名尘与土，八千里路云和月。莫等闲，白了少年头，空悲切!";
			byte[] sendMes = sendStr.getBytes();
			DatagramPacket dp = new DatagramPacket(sendMes,sendMes.length,addr,port);
			server.send(dp);
			server.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();

	}

}
