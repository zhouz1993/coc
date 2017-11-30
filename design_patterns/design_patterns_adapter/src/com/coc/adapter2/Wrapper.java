package com.coc.adapter2;
//对象的适配器模式
public class Wrapper implements Targetable {

	private Source source;
	
	public Wrapper(Source source){
		super();
		this.source = source;
	}
	
	@Override
	public void methodTwo() {
		System.out.println("这是Targetable方法。 ......Targetable -->Adapter -->methodTwo");
		
	}

	@Override
	public void methodOne() {
		source.methodOne();
	}
	

}
