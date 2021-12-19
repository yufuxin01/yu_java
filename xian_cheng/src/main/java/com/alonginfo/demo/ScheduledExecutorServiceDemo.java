package com.alonginfo.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService mScheduledService  = Executors.newScheduledThreadPool(2);
		System.out.println("ScheduledExecutorServiceDemo --- main start, " + Thread.currentThread().getName());
		mScheduledService.schedule(new CountDown(), 2 , TimeUnit.SECONDS);
		System.out.println("ScheduledExecutorServiceDemo --- main end, " + Thread.currentThread().getName());
		mScheduledService.shutdown();
	}
}
