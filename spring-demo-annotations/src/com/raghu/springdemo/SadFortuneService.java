package com.raghu.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your sad day";
	}

}
