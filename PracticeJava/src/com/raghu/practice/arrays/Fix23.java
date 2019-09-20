package com.raghu.practice.arrays;

public class Fix23 {
	
	public static int[] fix23(int[] nums) {
		int[] b = nums;
		boolean c = false;
		for (int i = 0; i <= nums.length-2; i++) {
			
			if(nums[i] == 2 && nums[i+1]==3) {
				c = true;
				b[i+1] =0;
				
			}
			
		}
		if (c) {
			return b;
			
		}
		else {
			return nums;
		}
		//return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
   int c[] = fix23(a);
   for (int i = 0; i < c.length; i++) {
	System.out.println(c[i]);
}
	}

}
