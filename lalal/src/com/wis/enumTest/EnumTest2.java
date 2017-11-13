package com.wis.enumTest;

import org.junit.Test;

public class EnumTest2 {
	
	@Test
	public void test1() {
		System.out.println( Color2.RED.getName() );
		System.out.println( Color2.RED.getIndex() );
		System.out.println( Color2.RED );
		
		for( Color2 color : Color2.values() ){
			System.out.println( color + " name: " +color.getName() +" index: " + color.getIndex());
		}
		
		System.out.println( Color2.values() );
	}
	
	
}
