package com.alonginfo.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
	private boolean waxOn = false;
	//涂蜡操作
	public synchronized void waxed(){
		waxOn = true;   //已经涂蜡了，下一步可以 抛光了
		notifyAll();
	}
	//抛光操作
	public synchronized void buffing() {
		waxOn = false;   
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn == false) {
			wait();
		}
	}
	public synchronized void waitForBuffing() throws InterruptedException{
		while (waxOn == true){
			wait();
		}
	}
}//end of "class Car"

//执行 涂蜡 任务
class WaxOn implements Runnable{
	private Car mCar;
	
	public WaxOn(Car mCar) {
		this.mCar = mCar;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()){
				System.out.println("WaxOn, 开始涂蜡     " + Thread.currentThread().getName());
				TimeUnit.MILLISECONDS.sleep(200); //模拟 涂蜡需要的 耗时
				mCar.waxed();
				mCar.waitForBuffing();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("WaxOn, exiting via interrupt  " + Thread.currentThread().getName());
		}
		System.out.println("WaxOn, ending of task  " + Thread.currentThread().getName());
	}
	
}//end of "class  WaxOn"

//执行 抛光
class Buffed implements Runnable{
	private Car mCar;
	public Buffed(Car mCar) {
		this.mCar = mCar;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()){
				mCar.waitForWaxing();
				System.out.println("Buffed, 开始抛光    " + Thread.currentThread().getName());
				TimeUnit.MILLISECONDS.sleep(300); //模拟抛光需要的耗时
				mCar.buffing();
			}
		} catch (InterruptedException e) {
			System.out.println("Buffed, exiting via interrupt  " + Thread.currentThread().getName());
		}
		System.out.println("Buffed, ending of task  " + Thread.currentThread().getName());
	}
}

public class WaxAndBuff {
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Buffed(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(3); //main 线程sleep几秒钟
		exec.shutdownNow();// interrupt,中断所有的任务

	}
}
