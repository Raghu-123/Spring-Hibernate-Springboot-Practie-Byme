package com.raghu.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CarromConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		//get the bean from spring container
		Coach theCoach = context.getBean("carromCoach", Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();
		
	}

}
