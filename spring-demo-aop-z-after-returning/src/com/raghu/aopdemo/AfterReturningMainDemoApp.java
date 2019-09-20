package com.raghu.aopdemo;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghu.aopdemo.dao.AccountDao;

public class AfterReturningMainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				                  new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
		
		//call the method to find accounts
		List<Account> theAccounts = accountDao.findAccounts();
		
		//display the accounts
		
		System.out.println("\n\nMain Program : AfterReturningMainDemoApp");
		
		System.out.println("-------");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		//close the context
		
		context.close();
		

	}

}
