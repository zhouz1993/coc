package com.wis.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class B extends A {
	public B(){
		super();       //编译出错 super() 必须放在第一行
		System.out.println("BBBBB");
	}
	
}
