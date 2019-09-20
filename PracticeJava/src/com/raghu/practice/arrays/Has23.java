package com.raghu.practice.arrays;

public class Has23 {

	public static boolean has23(int[] b) {
		for (int i = 0; i < b.length; i++) {
			if(b[i] == 2   || b[i] ==  3) {
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2};
		boolean b = has23(a);
System.out.println(b);
	}

}
