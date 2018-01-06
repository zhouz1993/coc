package com.coc.reflect;

public class ClassDemo1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Foo foo = new Foo();
		
		//Only the Java Virtual Machine creates Class objects.
	//	1：Class  c1=Foo.class;  ------->实际在告诉我们，任何一个类都有一个隐含的静态成员变量
		Class c1 = Foo.class;
		System.out.println(c1.getName());
		System.out.println(c1.getCanonicalName());
		System.out.println(c1.getSimpleName());
	//	System.out.println(c1.getTypeName());
		
		Package pk = c1.getPackage();
		System.out.println(pk.getName());
		
		
		
	//	2: Class  c2=foo1.getClass()---->已知该类的对象，通过该类的对象通过getClass方法
	//	   c1和c2表示Foo类的类 类型（class type）  Foo这个类本身就是一个对象，Foo类的对象：
		Class c2 = foo.getClass();
	//	3:Class c3=null;  class3=Class.forName();
		Class c3 = Class.forName("com.coc.reflect.Foo");
		System.out.println(c1==c2);
		System.out.println(c2==c3);
		System.out.println(c1==c3);
	//	c1==c2==c3
		
		try {
			
			Foo foo1 = (Foo)c1.newInstance();
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	
	public void printff(String...strings ){}
}
class Foo extends Goo implements Moo{}
class Goo{}
interface Moo{}