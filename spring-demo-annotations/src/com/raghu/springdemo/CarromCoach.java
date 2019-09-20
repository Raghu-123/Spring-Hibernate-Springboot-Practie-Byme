package com.raghu.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class CarromCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	

	@Value("${foo.team}")
	private String team;
	
     public CarromCoach(FortuneService fortuneService) {
    	 this.fortuneService = fortuneService;
		
	}
	@Override
	public String getDailyWorkOut() {
		
		return "practice daily 3 hours";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
	
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return team;
	}

}
