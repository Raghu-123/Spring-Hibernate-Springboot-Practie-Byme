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
	
	//create a pointcut for setter methods
	@Pointcut("execution(* com.raghu.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create a pointcut for getter methods
	@Pointcut("execution(* com.raghu.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	
	//create a pointcut: include package ... and exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	public void forDoaPackageNoSetterGetter() {}
	
	// for executing getter and setter also
	
	/*
	 * @Before("forDaoPackage()") public void beforeAddAccountAdvice() {
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
	
	@Before("forDoaPackageNoSetterGetter()")
	public void performAnalytics() {
		System.out.println("\n====> Performing API analytics");
	}
	
}
