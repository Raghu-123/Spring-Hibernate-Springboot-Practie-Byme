package com.raghu.practice.threads;

public class EvenOddInThreads extends Thread {
	public int MAX_NUNBERS = 10;
	static volatile int number = 1;
	static Object lock=new Object();
	@Override
	public void run() {

		while(number < MAX_NUNBERS) {
			//synchronized (EvenOddInThreads.class) {

			printnumber(number);


		}

	}
	public synchronized void printnumber(int num) {

		System.out.println("Current Thread is  is :"+Thread.currentThread().getName()+"number is :"+num);
		number++;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EvenOddInThreads eoit = new EvenOddInThreads();
		EvenOddInThreads eoit1 = new EvenOddInThreads();

		eoit.start();
		eoit1.start();

	}

}
