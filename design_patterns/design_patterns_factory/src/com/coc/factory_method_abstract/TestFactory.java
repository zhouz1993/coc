package com.coc.factory_method_abstract;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFactory {

	@Test
	public void test1() {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();
		Provider provider1 = new SendSmsFactory();
		Sender sender1 =provider1.produce();
		sender1.send();
	}

}
