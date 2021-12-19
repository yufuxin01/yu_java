package com.alonginfo.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FixedThreadPool{
	public static void main(String[] args) {
		int ThreadCount = 2;	
		ExecutorService exec = Executors.newFixedThreadPool(ThreadCount);
		
		System.out.println("main start  "  + Thread.currentThread().getName());
		for (int i=0; i<3; i++){
			exec.execute(new CountDown());
		}
		exec.shutdown();
		System.out.println("main end  "  + Thread.currentThread().getName());
		
	}
}
