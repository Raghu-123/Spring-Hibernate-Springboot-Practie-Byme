package com.raghu.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

//	@Autowired
//	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
//	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">>> Inside the Default constructor of TennisCoach");
	}

	//constructor dependency using annotations and also usage of @Qualifier in constructor
	  @Autowired 
	  public TennisCoach(@Qualifier("randomFortuneService")FortuneService fortuneService) {
	  this.fortuneService = fortuneService; }
	  
	 

	// define a setter method
//	 @Autowired
//	 public void setFortuneService(FortuneService theFortuneService) {
//		 System.out.println(">>> Inside the Setter method of TennisCoach");
//		 fortuneService = theFortuneService;
//	 }

	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService theFortuneService) {
	 * System.out.println(">>> Inside the doSomeCrazyStuff: method of TennisCoach");
	 * fortuneService = theFortuneService; }
	 */

	@Override
	public String getDailyWorkOut() {

		return "Practice your Backend Volley...";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
