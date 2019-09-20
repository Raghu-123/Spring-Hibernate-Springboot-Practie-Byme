package com.raghu.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.raghu.aopdemo.Account;

@Component
public class AccountDao {

	private String name;
	private String serviceCode;
	
	
	public void addAccount() {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING USER DEFINED  ACCOUNT");
	}
	
	public String getName() {
		System.out.println(getClass()+" :in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" :in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+" :in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" :in setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
