package com.coc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	/**
	 * 打印类的信息，包括类的成员函数、成员变量
	 * @param obj
	 */
	public static void printClassMessage(Object obj) {
		//获取类的类类型
		Class c = obj.getClass();
		System.out.println("类的名称： "+c.getName());
		
		
	}

	//获取成员变量
	public static void printFieldsMessage(Object obj) {
		Class c = obj.getClass();
		// 获取成员变量信息
		Field[] fs = c.getDeclaredFields();
		for(Field f : fs){
			Class fieldType = f.getType();
			String typeName = f.getName();
			
			String fieldName = f.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}

	// 获取成员函数
	public static void printMethodsMessage(Object obj) {
		Class c = obj.getClass();
		//获取方法信息
		Method[] ms = c.getMethods(); //.getDeclaredMethods()
		for(int i = 0; i<ms.length; i++){
			//得到方法返回值的类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName()+"  ");
			//得到方法的名称
			System.out.print(ms[i].getName()+ "(");
			// 获取参数类型 ---> 得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for(Class class1 : paramTypes){
				System.out.print(class1.getName()+",");
			}
			System.out.print(")");
			System.out.println();
		}
	}
	
	//获取构造函数的
	public static void printConstructorsMessage(Object obj) {
		Class c = obj.getClass();
		Constructor[] cs = c.getDeclaredConstructors();
		for(Constructor con : cs){
			System.out.print(con.getName()+"(");
			Class[] paramTypes = con.getParameterTypes();
			for(Class class1 : paramTypes){
				System.out.print(class1.getName()+",");
			}
			System.out.print(")");
			System.out.println();
		}
		
	}
	
	
}
