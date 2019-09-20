package com.raghu.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SentenceExample {
	
	public static int nonUnique(List<Integer> list1) {
		int res =1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (list1 != null && !list1.isEmpty()) {
			
			for (int i = 0; i < list1.size(); i++) {
				if (!map.containsKey(list1.get(i))) {
					
					map.put(list1.get(i),1);
					
				}
				else{
					map.put(list1.get(i),map.get(list1.get(i)+1));
				}
			}
			
			Set<Integer> set= map.keySet();
			for (Integer integer : set) {
				
				if (map.get(integer) > 2) {
					res++;
					
				}
				
			}
		}
		
		return res;
	}

public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1,2,3,4,5,1,1,2,2,1);
	
	int n = nonUnique(list);
	System.out.println(n);
	
}
}
