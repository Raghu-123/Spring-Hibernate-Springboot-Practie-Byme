package com.raghu.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.raghu.aopdemo.Account;

@Component
public class AccountDao {

	private String name;
	private String serviceCode;
	
	//add new method findAccounts
	public List<Account> findAccounts(boolean tripwire){
		//for academic purpose .. simulate an exception
		if (tripwire) {
			
			throw new RuntimeException("No Soup for you!!");
			
		}
		List<Account> myAccounts = new ArrayList<>();
		
		//create some sample accounts
		Account temp1 = new Account("Raghu", "Silver");
		Account temp2 = new Account("Janaki", "Platinum");
		Account temp3 = new Account("Saradha", "Gold");
		
		//add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp3);
		myAccounts.add(temp2);
		return myAccounts;
	}
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
