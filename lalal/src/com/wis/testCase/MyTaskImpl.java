package com.wis.testCase;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class MyTaskImpl implements MyTask {

	@Override
//	@Scheduled(cron="0/5 * * * * ? ")
	public void myTest() {
		System.out.println("hello");

	}

}
