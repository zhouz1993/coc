package com.coc.builder;

import static org.junit.Assert.*;

import java.util.List;

public class Test {

	@org.junit.Test
	public void test() {
		Builder builder = new Builder();
		
		List<Sender> list = builder.produceMailSender(10);
		
		for(Sender m : list){
			m.send();
		}
		
		
		System.out.println(" Test .....");
	}

}
