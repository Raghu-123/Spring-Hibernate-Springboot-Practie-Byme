package com.raghu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	// for executing getter and setter also
	
	/*
	 * @Before("forDaoPackage()") 
	 * public void beforeAddAccountAdvice() {
	 * System.out.println("\n====>>> Executing @Before advice on addAccount()");
	 * 
	 * //System.out.println("\n====>>> Executing @Before vice on updateAccount()");
	 * }
	 */
	
	 //for executing setter and getter methods
	/*
	 * @Before("forDaoPackage()") public void performAnalytics() {
	 * System.out.println("\n====> Performing API analytics"); }
	 */
	
	
	
	@Before("com.raghu.aopdemo.aspect.LuvAopExpressions.forDoaPackageNoSetterGetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
	}
	
	
	
	
	
}
