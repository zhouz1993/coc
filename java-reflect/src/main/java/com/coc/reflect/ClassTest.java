package com.coc.reflect;

public class ClassTest {

	public static void main(String[] args) {
		String s = "hello";
		ClassUtil.printClassMessage(s);
		System.out.println("==========================");
		ClassUtil.printMethodsMessage(s);
		System.out.println("==========================");
		ClassUtil.printFieldsMessage(s);
		System.out.println("==========================");
		ClassUtil.printConstructorsMessage(s);
	}

}
