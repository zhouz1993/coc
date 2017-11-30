package com.coc.factory_method;

public class SendFactory {
	/**
	 * 第一种方式：普通工厂模式
	 * 工厂模式  通过工厂来创建对象
	 * 需要传递一个type 参数
	 * @param type
	 * @return
	 */
	 public Sender produce(String type){
		 if("mail".equals(type)){
			 return new MailSender();
		 }else if("sms" .equals(type)){
			 return new SmsSender();
		 }else{
			 System.out.println("类型错误");
			 return null;
		 }
	 }
	 
	 /**
	  * 第二种方式：多个工厂方法模式，
	  * @return
	  */
	 public Sender produceMail(){
		 return new MailSender();
	 }
	 public Sender produceSms(){
		 return new SmsSender();
	 }
	 
	 /**
	  * 第三种：静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
	  * @return
	  */
	 public static Sender produceMail2(){
		 return new MailSender();
	 }
	 public static Sender produceSSms(){
		 return new SmsSender();
	 }
	 
	 
	 
}
