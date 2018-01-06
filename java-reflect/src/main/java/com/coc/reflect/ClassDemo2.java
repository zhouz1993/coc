package com.coc.reflect;

public class ClassDemo2 {

	public static void main(String[] args) {
		Class c1 = int.class;  //int 的类类型
		Class c2 = String.class;
		Class c3 = Integer.class;
		Class c4 = void.class;
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c4.getName());
		
	}

}
