package com.raghu.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemeberShipDao {

	
	public void addAccount() {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
	}
	
	public boolean addMember() {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING A MEMBERSHIP MEMEBER");
		
		return true;
		
	}
	
	public void goToSleep() {
		System.out.println(getClass()+ " Going to Sleep");
	}
}
