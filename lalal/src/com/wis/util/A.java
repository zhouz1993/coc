package com.wis.util;

public class A {
	private static int count = 0;
	public A(){
		count ++ ;
		System.out.println("AAAA");
	}
	public static int getNumber(){
		return count;
	}
}
