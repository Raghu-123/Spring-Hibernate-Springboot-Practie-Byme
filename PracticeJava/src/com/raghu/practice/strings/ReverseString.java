package com.raghu.practice.strings;

import java.util.Scanner;

public class ReverseString {

	public static void reverseString(String s) {
		for (int i = s.length() -1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		System.out.println();
		//StringBuilder sb = new StringBuilder(s);
		StringBuffer sb = new StringBuffer(s);
		sb.reverse().toString();
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		reverseString(str);

	}

}
