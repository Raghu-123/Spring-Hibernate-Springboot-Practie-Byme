package com.raghu.practice.threads;

public class HackerRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			badMethod();
			System.out.println("A");
		} catch (Exception e) {
			System.out.println("B");
		}
		finally {
			System.out.println("C");
		}

	}
	
	public static void badMethod() {}

}
