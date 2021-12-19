package com.alonginfo.demo;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class TaskWithResult implements Callable<String> {
	public String call() throws Exception {		
		return "result of TaskWithResult from Callable "  + "\t " + Thread.currentThread().getName();
	}
}


public class CallableDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		
		System.out.println("main  start\t" + Thread.currentThread().getName());
		Future<String> fs = exec.submit(new TaskWithResult());
		exec.shutdown();
		
		try {
			//当callable对象并没有完成时，这里一直是堵塞的。
			System.out.println(fs.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main  end\t" + Thread.currentThread().getName());
	}	
}
