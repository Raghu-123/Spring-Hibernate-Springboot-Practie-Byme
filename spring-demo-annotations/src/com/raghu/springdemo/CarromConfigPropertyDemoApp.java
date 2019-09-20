package com.raghu.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CarromConfigPropertyDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		//get the bean from spring container
		CarromCoach theCoach = context.getBean("carromCoach", CarromCoach.class);
		
		//call a method on the bean
		System.out.println("\n"+theCoach.getDailyWorkOut());
		
		//call method to get daily fortune
		System.out.println("\n"+theCoach.getDailyFortune());
		
		//call our new Carrom methods
		System.out.println("\n Eamil Id is : "+theCoach.getEmail());
		
		System.out.println("\n Team is :"+theCoach.getTeam());
		//close the context
		context.close();
		
	}

}
