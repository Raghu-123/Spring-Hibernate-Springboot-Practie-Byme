package com.raghu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all our related advices for logging
	
	//let's start with an @Before advice
	
	//@Before("execution(public void com.raghu.aopdemo.dao.AccountDao.addAccount())")
	
	//@Before("execution(public void updateAccount())")
	
	//@Before("execution(void add*())")
	
	//it will match any return type and method starting with add in any class and with no arguments
	//@Before("execution(* add*())")
	
	//it will match any return type and method starting with add in any class and argument as Account object
    //@Before("execution(* add*(com.raghu.aopdemo.Account,..))")
	
	//it will match one or more  number arguments of type any
	//@Before("execution(* add*(..))")
	
	/*
	 * it will match any return type and all the methods of class present in the
	 * mentioned package com.raghu.aopdemo.dao and one or more number arguments of
	 * type any
	 */
	@Before("execution(* com.raghu.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before vice on addAccount()");
		
		//System.out.println("\n====>>> Executing @Before vice on updateAccount()");
	}
}
