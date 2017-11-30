package com.coc.singleton;
/**
 * 饿汉式和懒汉式区别
	从名字上来说，饿汉和懒汉，
	饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了，
	而懒汉比较懒，只有当调用getInstance的时候，才回去初始化这个单例。
 * @author Administrator
 *
 */
public class Test {

	@org.junit.Test
	public void test1() {
		Singleton2 s = Singleton2.getInstance();
		s.print();
	}

	@org.junit.Test
	public void test2() {
		Singleton3 s = Singleton3.getInstance();
		s.print();
	}
}
