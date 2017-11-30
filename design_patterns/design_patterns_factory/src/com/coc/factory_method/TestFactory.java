package com.coc.factory_method;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFactory {

	/**
	 *  第一种方式：普通工厂模式
	 */
	@Test
	public void test1() {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("mail");
		sender.send();
	}
	/**
	 * 第二种方式：多个工厂方法模式，
	 */
	@Test
	public void test2() {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produceMail();
		sender.send();
	}
	
	/**
	 *第三种：静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，
	 *不需要创建实例，直接调用即可。
	 */
	@Test
	public void test3() {
		Sender sender = SendFactory.produceSSms();
		sender.send();
	}

}
