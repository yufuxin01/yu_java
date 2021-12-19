package com.alonginfo.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool{
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		
		System.out.println("main start  "  + Thread.currentThread().getName());
		for (int i=0; i<3; i++){
			exec.execute(new CountDown());
		}
		
		exec.shutdown();
		System.out.println("main end  "  + Thread.currentThread().getName());
	}

}
