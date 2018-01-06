package com.coc.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) throws Exception {
		Boy boy = Boy.getOne();
		Boy boy2 = Boy.getOne();
		System.out.println(boy == boy2);
		
		Girl g = Girl.getOne();
		Girl g2 = Girl.getOne();
		System.out.println(g2 == g);
	}
	
	
}

class Boy{
	private static Boy one;
	private Boy(){}
	public synchronized static Boy getOne(){
		if(one == null){
			one = new Boy();
		}
		return one;
	}
}

class Girl {
	private static Girl one = new Girl();
	private Girl(){
	}
	public static Girl getOne(){
		return one;
	}
}
