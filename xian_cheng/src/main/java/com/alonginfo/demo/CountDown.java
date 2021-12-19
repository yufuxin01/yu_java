package com.alonginfo.demo;


public  class CountDown implements Runnable{
	protected int countDown = 5;
	private static int myId= 0;
	private final int taskId = myId++;
	public CountDown() {
		super();
	}

	
	public CountDown(int countDown) {
		super();
		this.countDown = countDown;
	}
	
	public String status() {
		return  "＃" + taskId + "#(" + (countDown>0 ? countDown : "Over") + "),  " + Thread.currentThread().getName();
	}
	@Override
	public void run() {
			while(countDown-- > 0){
				System.out.println(status());
				Thread.yield();
			}
	}
	
	public static void main(String[] args) {
		System.out.println("main start, " + Thread.currentThread().getName());
		new CountDown().run();
		System.out.println("main end, " + Thread.currentThread().getName());
	}
}
