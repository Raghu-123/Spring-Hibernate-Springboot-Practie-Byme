package com.raghu.aopdemo;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghu.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionsMainDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionsMainDemoApp.class.getName());

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				                  new AnnotationConfigApplicationContext(DemoConfig.class);
		
	//get the bean from the container
		TrafficFortuneService theFortuneSerivce = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n\nMain Program ..... AroundHandleExceptionsMainDemoApp");
		myLogger.info("Calling GetFortune");
		
		boolean tripWire = true;
		//call the fortune method
		
		String data = theFortuneSerivce.getFortune(tripWire);
		
		myLogger.info("\nToday's Traffic Fortune is: "+data);
		
		myLogger.info("Finished");
		//close the context
		
		context.close();
		

	}

}
