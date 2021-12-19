package com.alonginfo.demo;


public class ThreadRunnable{
	
	private static final String TAG = "LiftOff";

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		System.out.println("main start, " + Thread.currentThread().getName());
		for (int i=0; i<3; i++){
			Thread thread = new Thread(new CountDown());
			thread.start();
		}
		System.out.println("main end, " + Thread.currentThread().getName());
	}

}
