package com.coco.connectmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoyService {
	
	@Autowired
	private BoyRepository boyRepository;
	
	@Transactional
	public void insertTwo(){
		Boy bA = new Boy();
		bA.setName("AAAAA");
		bA.setAge(12);
		boyRepository.save(bA);
		
		Boy bB = new Boy();
		bB.setName("BBBBB");
		bB.setAge(22);
		boyRepository.save(bB);
	}
}
