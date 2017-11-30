package com.coc.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDemo {

	@Test
	public void test() {
		TestSingleton ts1 = TestSingleton.getInstance();
		TestSingleton ts2 = TestSingleton.getInstance();
		ts1.setName("kangkang");
		ts2.setName("mreadrt");
		
		ts1.printInfo();
		ts2.printInfo();
		
		if(ts1 == ts2){
			System.out.println("创建的是同一个实例");
		}else{
			System.out.println("创建的不是同一个实例");
		}
		
		/*结果：：
		 * this name is :mreadrt
			this name is :mreadrt
			创建的是同一个实例

		 */
	}

}
