package com.raghu.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//read the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		//get the bean from spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();
		
	}

}
