package com.raghu.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.raghu.aopdemo.Account;

@Component
public class AccountDao {

	
	
	public void addAccount() {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING USER DEFINED  ACCOUNT");
	}
	
	
	
}
