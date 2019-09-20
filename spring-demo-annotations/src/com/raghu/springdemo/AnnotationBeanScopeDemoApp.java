package com.raghu.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the bean from spring container
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if both objects are same
		boolean result = (theCoach == alphaCoach);
		System.out.println("\n Pointing to the same Object: "+result);
		
		System.out.println("\n The memory location of theCoach: "+theCoach);
		System.out.println("\n The memory location of alphaCoach: "+alphaCoach);
		
		context.close();
	}

}
