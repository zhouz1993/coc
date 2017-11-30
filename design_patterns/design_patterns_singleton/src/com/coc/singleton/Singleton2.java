package com.coc.singleton;
/**
 * 懒汉式单例
 * 
 * 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
   2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
   3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。
 * @author Administrator
 *
 */
public class Singleton2 {
	/* 私有构造方法，防止被实例化*/
	private Singleton2(){
	}
	 /* 此处使用一个内部类来维护单例 */  
	private static class SingletonFactory{
		private static Singleton2 instance = new Singleton2();
	}
	
	/*获取实例*/
	public static final Singleton2 getInstance(){
		return SingletonFactory.instance;
	}
	
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致*/
	public Object readResolve(){
		return getInstance();
	}
	
	public void print(){
		System.out.println("singleton .....");
	}
	
}
