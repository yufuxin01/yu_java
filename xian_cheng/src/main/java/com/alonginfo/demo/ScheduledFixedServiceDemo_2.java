package com.alonginfo.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledFixedServiceDemo_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService mScheduledService  = Executors.newScheduledThreadPool(2);
		System.out.println("ScheduledFixedServiceDemo_2 --- main start, " + Thread.currentThread().getName());
		mScheduledService.scheduleWithFixedDelay(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				System.out.println("fixed print = " + count++);
				
			}
		}, 1, 2 , TimeUnit.SECONDS);
		System.out.println("ScheduledFixedServiceDemo_2 --- main end, " + Thread.currentThread().getName());
	}
}
