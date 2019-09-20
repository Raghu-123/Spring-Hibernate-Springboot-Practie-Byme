package com.raghu.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.raghu.springdemo.controller.*.*(..))")
	public void forControllerPackage() {
		
	}
	//do the same for service and dao
	
	@Pointcut("execution(* com.raghu.springdemo.service.*.*(..))")
	public void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.raghu.springdemo.dao.*.*(..))")
	public void forDAOrPackage() {
		
	}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOrPackage()")
	public void forAppFlow() {
		
	}
	//add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display the method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("======> in @Before Calling method : "+method);
		
		//display the method arguments
		
		
		//get the arguments
		Object[] obj = theJoinPoint.getArgs();

		
		//loop through the arguments
		for (Object object : obj) {
			
			myLogger.info("======>> argument is :"+object);
		}
		
		
	}
	
	//add @AfterReturning

	@AfterReturning(pointcut="forAppFlow()", 
			returning="result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @AfterReturning method : "+method);
		
		//display the data returned
		
		myLogger.info("====> Result :" +result);
		
	}
	
}
