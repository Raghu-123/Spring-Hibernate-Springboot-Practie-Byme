package com.raghu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	/*
	 * pointcut declaration
	 * Here  forDaoPackage is declared variable 
	 * we will reuse wherever pointcut expression is required
	 */
	@Pointcut("execution(* com.raghu.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
		
		//System.out.println("\n====>>> Executing @Before vice on updateAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performAnalytics() {
		System.out.println("\n====> Performing API analytics");
	}
}
