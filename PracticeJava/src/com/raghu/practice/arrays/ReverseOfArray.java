package com.raghu.practice.arrays;

public class ReverseOfArray {

	public static int[] reversearray(int[] b) {
		int[] c = new int[b.length];
		int j =0;
		System.out.println(b.length);
		for (int i = b.length-1; i >=0; i--) {
			
			c[j] = b[i];
			System.out.println("in for"+c[j]);
			j++;
			
		}
		System.out.println("out side "+c[0]);
		return c;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,2,3};
		
		int[] z = reversearray(a);
		for (int i = 0; i < z.length; i++) {
			System.out.println(z[i]);
		}
		
		//System.out.println("The reverse of the given Array is :"+z);
		

	}

}
