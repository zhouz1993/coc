package com.coc.demo1;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo3 {
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
			//System.out.println(method);
			//检查方法method上是否包含 Test 注解
			//method.getAnnotation(被检查的注解);
			//返回值 如果为null表示方法上没有这
			//个注解, 如果返回注解类型对象,表示包含注解
			if(method.getAnnotation(Test.class) != null){
				System.out.println("找到Test注解： ");
				method.setAccessible(true);
				method.invoke(obj);
			}else{
				System.out.println("没有找到Test注解 -----");
			}
		}
		
	}
}
