package com.coc.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ClassDemo3 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		ArrayList<String> list2 = new ArrayList();
		list2.add("hello");
	//	list2.addAll(213);
		Class c1 = list.getClass();
		Class c2 = list2.getClass();
		System.out.println(c1 == c2);
		
		try {
			Method m = c2.getMethod("add", Object.class);
			m.invoke(list2, 1000);
			System.out.println(list2.size());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
