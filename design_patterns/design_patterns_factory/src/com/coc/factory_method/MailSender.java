package com.coc.factory_method;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is  MailSender ... ");
	}

}
