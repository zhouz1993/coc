package com.coc.factory_method_abstract;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println(" this id SmsSender ....");
	}

}
