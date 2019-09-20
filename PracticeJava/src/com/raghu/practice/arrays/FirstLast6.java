package com.raghu.practice.arrays;

public class FirstLast6 {
	static boolean f = false;
	
	private static boolean firstlast6(int[] b) {
		if(b[0] == 6 || b[b.length -1] == 6) {
		f = true;
		}
		
		else {
			f = false;
		}
		
		return f;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		
System.out.println("Did the array has 6 in first or last ? " + firstlast6(a));
	}

}
