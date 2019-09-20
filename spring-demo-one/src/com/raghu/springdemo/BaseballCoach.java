package com.raghu.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneSerive;
	
 
	public BaseballCoach() {
		
	}
	public BaseballCoach(FortuneService fortuneSerive) {
		this.fortuneSerive = fortuneSerive;
	}


	@Override
	public String getDailyWorkout() {
		return "spend 30 minutes on batting practice...";
	}
	
	public String getDailyFortune() {
		
		return fortuneSerive.getFortune();
	}
	//add an init method
	
	public void doMyStartupStuff() {
		System.out.println("BaseballCoach : Inside method doMyStartupStuff");
	}
	
	//add destroy method
    public void doCleaupStuff() {
    	System.out.println("BaseballCoach : Inside method doCleaupStuff");
    }
}
