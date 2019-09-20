package com.raghu.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		//Retrieve the bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//Check if they are same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nResult :"+result);
		
		System.out.println("\n Memory location for theCoach: "+theCoach);
        
		System.out.println("\n Memory location for alphaCoach: "+alphaCoach);
		
		//close the context
		
		context.close();
	}

}
