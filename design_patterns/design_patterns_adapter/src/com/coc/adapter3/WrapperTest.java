package com.coc.adapter3;

import static org.junit.Assert.*;

import org.junit.Test;

public class WrapperTest {

	@Test
	public void test() {
		Sourceable source1 = new SourceSubOne();
		Sourceable source2 = new SourceSubTwo();
		
		source1.methodOne();
		source1.methodTwo();
		
		source2.methodOne();
		source2.methodTwo();
	}

}
