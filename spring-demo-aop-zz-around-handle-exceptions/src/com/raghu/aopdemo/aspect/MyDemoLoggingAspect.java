package com.raghu.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//handle exceptions
	
	@Around("execution(* com.raghu.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		
		//print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n ====> Executing @After (Finally) on ");
		System.out.print("Method name is :"+method);
		
		
		//get the begin timestamp
		long begin = System.currentTimeMillis();
		
		
		//now , let's execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
		
			//log the exception
			
		myLogger.warning(e.getMessage());
			/*
			 * //give the user a custom message result = "Major Accident! But no worries , "
			 * + "Your  private AOP helicopter is on the way";
			 */
		//re-throwing the exception
		throw e;
		}
		
		//get the end timestamp
		long end = System.currentTimeMillis();
		
		//compute the duration and display it
		long duration = end - begin;
		
		myLogger.info("\n=====> Duration : "+ duration/1000.0 +" seconds");
		
		return result;
	}
	
	
	
	
	@After("execution(* com.raghu.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccounts(JoinPoint theJoinPoint) {
		
		//print out which method we are advising on
		
				String method = theJoinPoint.getSignature().toShortString();
				myLogger.info("\n ====> Executing @After (Finally) on");
				myLogger.info("Method name is :"+method);
		
	}
	
 
	@AfterThrowing(pointcut="execution(* com.raghu.aopdemo.dao.AccountDao.findAccounts(..))",
			throwing="exec")
	public void afterThrowingFindAccounts(JoinPoint theJoinPoint, Throwable exec ) {
		//print out which method we are advising on
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====> Executing @AfterThrowing on");
		myLogger.info("Method name is :"+method);
		
		//log the exception
		myLogger.info("\n The execption is :"+exec);
	}
	
	//add a new advice for @AfterReturningon the find accounts
	
	@AfterReturning(pointcut="execution(* com.raghu.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//print out which method we are advising on
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====> Executing @AfterReturning on");
		
		//print out the results of the method call
		myLogger.info("\n ====>result is :"+result);
		
		//let's post process the data
		
		//convert the account names to the uppercase
		convertAccountNamesToUpperCae(result);
		
		myLogger.info("\n ====>result After modifying  name to uupercase :"+result);
	}
	
	
	
	private void convertAccountNamesToUpperCae(List<Account> result) {
		//loop through the account objects
		
		for (Account account : result) {
			
		
		//get the uppercase  version of the account name
			String theUpperName = account.getName().toUpperCase();
		
		//update the name on the account
			account.setName(theUpperName);
		}
	}



	@Before("com.raghu.aopdemo.aspect.LuvAopExpressions.forDoaPackageNoSetterGetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
		
		//display the method signature
		MethodSignature methsig = (MethodSignature)theJoinPoint.getSignature();
		
		myLogger.info("Method: "+methsig);
		//display method arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		for (Object object : args) {
			
			myLogger.info(object.toString());
			
			if (object instanceof Account) {
				//down cast and print account specific stuff
				Account theAccount = (Account) object;
				myLogger.info("Account Name: "+theAccount.getName());
				myLogger.info("Account Level: "+theAccount.getLevel());
				
				
			}
			
		}
	}
	
	
	
	
	
}
