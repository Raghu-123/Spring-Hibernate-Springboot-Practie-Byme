package com.raghu.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	
	//add a new advice for @AfterReturningon the find accounts
	
	@AfterReturning(pointcut="execution(* com.raghu.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//print out which method we are advising on
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ====> Executing @AfterReturning on");
		
		//print out the results of the method call
		System.out.println("\n ====>result is :"+result);
		
		//let's post process the data
		
		//convert the account names to the uppercase
		convertAccountNamesToUpperCae(result);
		
		System.out.println("\n ====>result After modifying  name to uupercase :"+result);
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
