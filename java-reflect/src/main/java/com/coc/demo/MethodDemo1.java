package com.coc.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		// 获取print方法
		A a1 = new A();
		Class c = a1.getClass();
		
		try {
			Method m = c.getDeclaredMethod("print", new Class[]{int.class,int.class});
		//	Method m2 = c.getDeclaredMethod("print",int.class,int.class);
		//	Object o = m.invoke(a1,1, 2);
			Object  o = m.invoke(a1, new Object[]{10,20});
			System.out.println(o);
			
			Method m1 = c.getDeclaredMethod("print", new Class[]{String.class,String.class});
			o = m1.invoke(a1, new Object[]{"hello","WORLD"});
			System.out.println(o);
			
			Method m2 = c.getDeclaredMethod("print");
			o = m2.invoke(a1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class A{
	public void print(int a, int b){
		System.out.println(a+b);
	}
	public void print(String a,String b){
		System.out.println(a.toUpperCase()+", "+ b.toLowerCase());
	}
	public void print(){
		System.out.println("hello world");
	}
}