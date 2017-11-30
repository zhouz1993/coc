package com.coc.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProxy {

	@Test
	public void test() {
		Sourceable source = new Proxy();
		source.method();
	}

}
