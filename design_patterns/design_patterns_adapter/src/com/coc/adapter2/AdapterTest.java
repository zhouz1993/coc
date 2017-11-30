package com.coc.adapter2;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdapterTest {

	@Test
	public void test() {
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.methodOne();
		target.methodTwo();
	}

}
