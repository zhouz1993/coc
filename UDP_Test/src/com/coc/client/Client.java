package com.coc.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
	private InetAddress addr ;
	private int port;
	
	public Client(){
		try {
			addr = InetAddress.getByName("127.0.0.1");
			port = 8088;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	private void start(){
		try {
			//向服务端发送数据
			DatagramSocket client = new DatagramSocket();
			String sendMessage = "怒发冲冠，凭栏处，潇潇雨歇。抬望眼，仰天长啸，壮怀激烈。";
			byte[] sendBuff = sendMessage.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendBuff,sendBuff.length,addr,port);
			client.send(sendPacket);
			
			//接受服务端的数据
			byte[] recvBuf = new byte[100];
			DatagramPacket recvPacket = new DatagramPacket(recvBuf,recvBuf.length);
			client.receive(recvPacket);
			String recvMessage = new String(recvPacket.getData(),0,recvPacket.getLength());
			System.out.println("服务端说:  "+recvMessage);
			
			client.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

}
