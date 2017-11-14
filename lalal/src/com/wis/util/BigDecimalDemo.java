package com.wis.util;

import java.math.BigDecimal;

public class BigDecimalDemo {
	public static void main(String[] args) {
		//Test1();
		//test2();
		//test3(); 
		
		
	}

	private static void test3() {
		short s = 1;
	//	s = s+1;  
		s += 1;
		
		System.out.println(99%2);
		System.out.println(98%2);
	}

	private static void test2() {
		int a = 2*16;
		int b = 2 << 4;
		System.out.println(b);
		System.out.println(a == b);
	}

	private static void Test1() {
		BigDecimal a = new BigDecimal("6");
		BigDecimal b = new BigDecimal("2.4");
		BigDecimal c = a.subtract(b);
		
		double value = c.doubleValue();
		
		System.out.println(a.subtract(b));
		System.out.println(value);
		System.out.println(value == 3.6);
	}
}
