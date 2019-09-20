package com.raghu.practice.inheritance;

public class Child extends Parent {
	
	int x = 20;
	static {
		System.out.println("this is static block...");
	}
	
 static void print() {
	 System.out.println("this is print method");
 }
 
 
	
	public void address() {
		System.out.println("Name of the person is "+x);
	}
	
	public  void name() {
	
		System.out.println("Updating the child address");
	}

	public static void main(String[] args) {
		Parent c = new Child();
		//c.address();
		c.name();
		//print();
	}
}
