package com.raghu.practice.arrays;

public class Sum2 {
	
	public static int  sum21(int[] b) {
		int len = b.length;
		int sum =0;
		if(len >= 2) {
			sum = b[0]+b[1];
		}
		else {
			sum = b[0];
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1};
      int sum1 = sum21(a);
      System.out.println(sum1);
	}


}
