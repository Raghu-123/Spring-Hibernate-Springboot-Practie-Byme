package com.raghu.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create an array of strings
	private String[] data= {"Beware of the wolf in sheep's clothing",
			                "Diligence is th mother of good luck!",
			                "THe journey is the reward"};

	private Random myRandom = new Random();
	@Override
	public String getFortune() {
		// pick a random string form the array 
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
