package com.wis.testCase;

import java.net.*;

public class TCPAddress {
	public static void main(String[] args){
		InetAddress ip;
		
		try{
			ip=InetAddress.getLocalHost();
			String localname = ip.getHostName(); //获取本机名
			String localip = ip.getHostAddress(); //获取本机ip地址
			System.out.println("ip: "+ip);
			System.out.println("localname: " + localname);
			System.out.println("localip: "+localip);
			
//			ip = InetAddress.getByName("Garen");
//			System.out.println("ipip: "+ip);
//			String localname = ip.getHostName(); //获取本机名
//			String localip = ip.getHostAddress(); //获取本机ip地址
//			System.out.println("ip: "+ip);
//			System.out.println("localname: " + localname);
//			System.out.println("localip: "+localip);
			
		//	ip=InetAddress.getLoopbackAddress();
		//	System.out.println(ip);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
}
