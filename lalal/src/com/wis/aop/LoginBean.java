package com.wis.aop;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Component 作用于定时器
 * @author WH1607050
 *
 */
@Component
@Aspect
public class LoginBean {
	/**
     * 切面的前置方法 即方法执行前拦截到的方法 记录并输出
     * 在目标方法执行之前的通知    execution  方 法限定表达式  
     * 
     * @Pointcut 切入点
     * @param 
     */
//	@Pointcut("execution(* com.wis.service.implement.*.delete(..))")
//	public void pointCut(){	}
	
//	@Before("pointCut()")
	@Before("execution(* com.wis.service.implement.*.delete(..))")
//	@Scheduled(cron = "0 45 17 * * ? ")
	public void before(JoinPoint joinPoint) {
		System.out.println("10秒之后执行delete方法");
	//	myTask();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	 /**
     * 切面的后置方法，不管抛不抛异常都会走此方法
     * 在目标方法执行之后的通知
     * @param 
     */
 	@AfterReturning("execution(* com.wis.service.implement.*.delete(..))")
//	@AfterReturning("pointCut")
	public void afterReturn(JoinPoint joinPoint){
		System.out.println("后置通知！");
	}

	@Scheduled(cron = "0 55 17 * * ? ")
//	@Scheduled(fixedDelay = 5000)
//	@Scheduled(fixedRate=5000)
	public void myTask(){
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = f.format(date);
		System.out.println(d);
	}
	
	
	
}











