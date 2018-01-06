package com.coc.demo1;

public class TestCase {

	public void demo(){
		System.out.println("TestCase : Demo()");
	}
	
	public void testSaveUser(){
		System.out.println("Save User");
	}
	
	@Test
	public void testHello(){
		System.out.println("Hello World !");
	}
	
	@Test
	public void testHelloKitty(){
		System.out.println("Hello kitty");
	}
	
}
