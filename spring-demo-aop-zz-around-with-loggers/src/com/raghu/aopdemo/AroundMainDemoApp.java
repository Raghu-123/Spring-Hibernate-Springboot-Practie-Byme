package com.raghu.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghu.aopdemo.service.TrafficFortuneService;

public class AroundMainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				                  new AnnotationConfigApplicationContext(DemoConfig.class);
		
	//get the bean from the container
		TrafficFortuneService theFortuneSerivce = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\n\nMain Program ..... AroundMainDemoApp");
		System.out.println("Calling GetFortune");
		//call the fortune method
		
		String data = theFortuneSerivce.getFortune();
		
		System.out.println("\nToday's Traffic Fortune is: "+data);
		
		System.out.println("Finished");
		//close the context
		
		context.close();
		

	}

}
