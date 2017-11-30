package com.coc.factory_method_abstract;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is  MailSender ... ");
	}

}
