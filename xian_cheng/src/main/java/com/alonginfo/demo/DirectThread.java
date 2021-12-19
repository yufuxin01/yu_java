package com.alonginfo.demo;



public class DirectThread extends Thread{
	protected int countDown = 5;
	
	public String status() {
		return  "＃＃＃(" + (countDown>0 ? countDown : "Over") + "),  " + Thread.currentThread().getName();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(countDown-- > 0){
			System.out.println(status());
		}
	}

	public static void main(String[] args) {
		System.out.println("DirectThread --- main start, " + Thread.currentThread().getName());
		new DirectThread().start();
		System.out.println("DirectThread --- main end, " + Thread.currentThread().getName());
	}
}
