package com.raghu.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public  void swimCoachdetails() {
		System.out.println("Email ID is: "+email+"\n Team name is :"+team);
	}

	@Override
	public String getDailyWorkOut() {
		
		swimCoachdetails();
	
		return "Swimi hard for 30 mins..";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
	
	
	

}
