package com.coc.adapter;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdapterTest {

	@Test
	public void test() {
		Targetable target = new Adapter();
		target.methodOne();
		target.methodTwo();
	}

}
