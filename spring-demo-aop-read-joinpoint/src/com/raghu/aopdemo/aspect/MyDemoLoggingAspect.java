package com.raghu.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.raghu.aopdemo.Account;

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
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
		
		//display the method signature
		MethodSignature methsig = (MethodSignature)theJoinPoint.getSignature();
		
		System.out.println("Method: "+methsig);
		//display method arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		for (Object object : args) {
			
			System.out.println(object);
			
			if (object instanceof Account) {
				//down cast and print account specific stuff
				Account theAccount = (Account) object;
				System.out.println("Account Name: "+theAccount.getName());
				System.out.println("Account Level: "+theAccount.getLevel());
				
				
			}
			
		}
	}
	
	
	
	
	
}
