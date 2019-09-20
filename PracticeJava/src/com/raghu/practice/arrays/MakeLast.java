package com.raghu.practice.arrays;

public class MakeLast {
	
	public static int[] makeLast(int[] nums) {
		int len = nums.length;
		int newlen = 2*len;
		int[] b = new int[newlen];
		
		b[newlen-1] = nums[nums.length-1];
		
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,5,6};
		int[] c= makeLast(a);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}

	}

}
