package com.wis.enumTest;

import org.junit.Test;

public class EnumTest {
	
	static boolean isRed(Color color){
		if(Color.RED.equals(color)){
			return true;
		}
		return false;
	} 

	static void showColor(Color color){
		switch( color ){
		case BLANK:
			System.out.println(color);
			break;
		case RED:
			System.out.println(color);
			break;
		default:
			System.out.println( color );
			break;
		}
	}
	@Test
	public void test1() {
		boolean b1 = isRed(Color.BLANK);
		System.out.println(b1);
		boolean b2 = isRed(Color.RED);
		System.out.println(b2);
		
	}
	
	@Test
	public void test2(){
		showColor( Color.YELLOW );
	}
}
