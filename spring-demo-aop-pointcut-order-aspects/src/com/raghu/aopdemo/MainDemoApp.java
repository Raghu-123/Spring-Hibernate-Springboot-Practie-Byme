package com.raghu.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghu.aopdemo.dao.AccountDao;
import com.raghu.aopdemo.dao.MemeberShipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				                  new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
		
		//get the membership bean from spring container
		
		MemeberShipDao memeberShipDao = context.getBean("memeberShipDao",MemeberShipDao.class);
		
		//call the business method
		accountDao.addAccount();
		
		//call the argument addAccount method
		
		Account myAccount = new Account();
		
		accountDao.addAccount(myAccount,true);
		
		//call the accountDao setter/getter methods
		accountDao.setName("raghu");
		accountDao.setServiceCode("rag123");
		
		String name = accountDao.getName();
		String serivceCode = accountDao.getServiceCode();
		System.out.println("Name: "+name+"  SerivceCode: "+serivceCode);
		
		//call the membership business method
		memeberShipDao.addAccount();
		
		memeberShipDao.addMember();
		
		memeberShipDao.goToSleep();
		
		/*
		 * //lets call the method again
		 * System.out.println("\n let call the method again \n");
		 * accountDao.addAccount();
		 */
		
		
		//close the context
		context.close();
		
		

	}

}
