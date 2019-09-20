package com.raghu.practice.arrays;

public class MaxEnd3 {
	
	public static int[] maxEnd(int[] b) {
		int maxnum ;
		int[] c = new int[b.length];
		
		if(b[0] > b[b.length-1]) {
			maxnum = b[0];
		}
		else {
			maxnum = b[b.length-1];
		}
		
		for(int i = 0; i <= b.length-1; i++) {
			c[i] = maxnum;
		}
		
		return c;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {11,2,3};
		 int z[] = maxEnd(a);
		 for (int i = 0; i < z.length; i++) {
			System.out.println(z[i]);
		}

	}

}
