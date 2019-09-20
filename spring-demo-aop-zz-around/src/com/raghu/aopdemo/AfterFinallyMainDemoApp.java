package com.raghu.aopdemo;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghu.aopdemo.dao.AccountDao;

public class AfterFinallyMainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				                  new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
		
		//call the method to find accounts
		List<Account> theAccounts = null;
		
				try {
					//add a boolean flag to simulate exceptions
					boolean tripwire = true;
					theAccounts=accountDao.findAccounts(tripwire);
				} catch (Exception e) {
					System.out.println("\n\nMain program ... caught exception"+e);
					
				}
		
		//display the accounts
		
		System.out.println("\n\nMain Program : AfterThrowingMainDemoApp");
		
		System.out.println("-------");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		//close the context
		
		context.close();
		

	}

}
