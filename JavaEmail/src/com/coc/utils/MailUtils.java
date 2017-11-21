package com.coc.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	/**
	 * 发送邮件
	 * @param to ：发给谁
	 * @param code ：邮件激活码
	 * @throws MessagingException 
	 * @throws Exception 
	 */
	public static void sendMail(String to,String code) throws Exception{
		//创建连接对象
		Properties props = new Properties();
		//props.setProperty("host", "value");
		Session session = Session.getInstance(props, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@coc.com", "123");
			}
		});
		
		//创建邮件对象
		Message message = new MimeMessage(session);
		//设置发件人
		message.setFrom(new InternetAddress("service@coc.com"));
		//设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//设置邮件主题
		message.setSubject("来自COC网站激活邮件");
		//设置正文
		message.setContent("<h1>激活邮件，激活请点击以下链接：</h1><h3><a href='http://localhost:8080/JavaEmail/ActiveServlet?code="+code+"'>http://localhost:8080/JavaEmail/ActiveServlet?code="+code+"<a/></h3>", "text/html;charset=UTF-8");
		//发送一封邮件
		Transport.send(message);
		
		
	}
}
