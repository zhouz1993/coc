package com.coc.adapter;
//类的适配器模式，
public class Adapter extends Source implements Targetable {

	@Override
	public void methodTwo() {
		System.out.println("这是Targetable方法。 ......Targetable -->Adapter -->methodTwo");
		
	}
	

}
