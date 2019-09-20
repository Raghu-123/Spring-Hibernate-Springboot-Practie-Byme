package com.raghu.practice.threads;

import java.util.HashMap;
import java.util.Map;

public class ThreadDemo extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("this is "+Thread.currentThread()+" "+i);
			try {
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ThreadDemo td = new ThreadDemo();
		ThreadDemo td1 = new ThreadDemo();
		Map<String, Integer> map = new HashMap();
		//map.compute("raghu", );
	
		td.setName("Raghu");
		td1.setName("Janaki");
		td.start();
		
		td.join();
		td1.start();

	}

}
