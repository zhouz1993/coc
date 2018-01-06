package com.coc.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("输入类名: ");
		String className = in.nextLine();
		//动态加载类
		Class cls = Class.forName(className);
		//动态查询类中的全部方法信息
		Method[] methods = cls.getDeclaredMethods();
		//动态创建对象
		Object obj = cls.newInstance();
		for(Method method : methods){
		//	System.out.println(method);
			//在方法信息上获取方法名
			String name = method.getName();
			System.out.println(name);
			//检查方法是否以test为开头的
			if(name.startsWith("test")){
				System.out.println(method);
				//执行/调用(invoke)方法
				//obj 被执行方法的对象
				//arg 执行方法传递的参数
				// 如果没有参数就可以省略
				Object val = method.invoke(obj);
				System.out.println(val);
			}
			
		}
		
	}
}
