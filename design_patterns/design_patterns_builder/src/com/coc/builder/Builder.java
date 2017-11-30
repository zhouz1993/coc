package com.coc.builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {
	
	private List<Sender> list = new ArrayList<Sender>();
	
	public List<Sender> produceMailSender(int count){
		for(int i = 0;i<count; i++){
			list.add(new MailSender());
		}
		return list;
	}
	
	public List<Sender> produceMessSender(int count){
		for( int i = 0; i < count; i++){
			list.add(new MessSender());
		}
		return list;
	}
	
}
