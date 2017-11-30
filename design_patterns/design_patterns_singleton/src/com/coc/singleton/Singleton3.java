package com.coc.singleton;
/**
 * 饿汉式单例类.在类初始化时，已经自行实例化
 * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，
 * 以后不再改变，所以天生是线程安全的。
 * @author Administrator
 */
public class Singleton3 {
	private Singleton3(){}
	
	private static final Singleton3 singleton = new Singleton3();
	/* 静态工厂方法*/
	public static Singleton3 getInstance(){
		return singleton;
	}
	
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致*/
	public Object readResolve(){
		return singleton;
	}
	
	public void print(){
		System.out.println("singleton3 ...");
	}
}
