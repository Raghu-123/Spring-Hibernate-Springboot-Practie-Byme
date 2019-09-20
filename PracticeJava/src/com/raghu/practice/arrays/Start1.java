package com.raghu.practice.arrays;

public class Start1 {
	
	public static int start1(int[] a, int[] b) {
		int arraycount =0;
		if(a.length >=1 && a[0] == 1) {
		arraycount++;
		}
		if(b.length >= 1 && b[0] ==1) {
			arraycount++;
			}
		return arraycount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,2,3};
		int[] b = {0,2};
		int count = start1(a, b);
		System.out.println(count);

	}

}
