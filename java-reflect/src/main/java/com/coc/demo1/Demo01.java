package com.coc.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("输入类名: ");
		String className = in.nextLine();
		// Class 反射API的入口
		Class cls = Class.forName(className);
		//cls 引用了类的相关信息
		//利用反射API查询类中声明的全部属性信息
		Field[] fields = cls.getDeclaredFields();
		
		for(Field f : fields){
			System.out.print(f+" :  ");
			System.out.print(f.getType()+" : ");
			System.out.println(f.getName());
		}
		
		//可以获取类中全部的方法信息
		Method[] methods = cls.getDeclaredMethods();
		System.out.println("=========================");
		for(Method m : methods){
			System.out.println(m);
			System.out.println(m.getReturnType());
			System.out.println(m.getName());
		}
		
	}
}
