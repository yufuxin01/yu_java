package com.alonginfo.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Deprecated
public class ScheduledFixedServiceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService mScheduledService  = Executors.newScheduledThreadPool(2);
		System.out.println("ScheduledFixedServiceDemo --- main start, " + Thread.currentThread().getName());
		mScheduledService.scheduleWithFixedDelay(new CountDown(), 1, 2 , TimeUnit.SECONDS);
		System.out.println("ScheduledFixedServiceDemo --- main end, " + Thread.currentThread().getName());
		//Todo  这里其实没有理解
		//为什么这句话不屏蔽，这里就不进行输出了
//		mScheduledService.shutdown();
		
		
		
	}

}
