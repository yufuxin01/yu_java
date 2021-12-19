package com.alonginfo.demo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Chopstick{
	private boolean taken = false;
	//拿起筷子
	public synchronized void take() throws InterruptedException{
		while (taken){
			wait();
		}
		TimeUnit.MILLISECONDS.sleep(100);
		taken = true;
	}
	//放下筷子
	public synchronized void drop(){
		taken = false;
		notify();
	}
} //end of "class Chopstick"

class Philosopher implements Runnable{
	private Chopstick left;
	private Chopstick right; 
	private final int id;
	private int eatTime;
	private int thinkTime;
	private Random rand = new Random(42); //the Answer to Life, the Universe and Everything is 42
	
	public Philosopher(Chopstick left, Chopstick right, int id, int eatTime, int thinkTime) {
		super();
		this.left = left;
		this.right = right;
		this.id = id;
		this.eatTime = eatTime;
		this.thinkTime = thinkTime;
	}
	
	//思考/或者吃饭的一段时间。
	private void pause(int time) throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(time*20));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()){
				System.out.println(this + "thinking");
				pause(thinkTime);
				//哲学家开始吃饭了
				System.out.println(this + "grabbing right");
				right.take();
				System.out.println(this + "grabbing left");
				left.take();
				System.out.println(this + "grabbing eating");
				pause(eatTime);
				//吃完了。可以放下筷子了
				right.drop();
				left.drop();
				
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println(this + "  exiting via interrupt");
		}
	}

	@Override
	public String toString() {
		return "Philosopher id=" + id + "\t"; 
	}
	
	
	
}//end of "class Philosopher"

public class DeadLockingDiningPhiosophers {
	//哲学家和筷子的数量
	private static final int N = 3;
	private static final int eatTime = 20;
	private static final int thinkTime = 3;
	
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		int ponder = 1;
		Chopstick[] sticks = new Chopstick[N];
		
		for (int i=0; i<N; i++){
			sticks[i] = new Chopstick();
		}
		
		for (int i=0; i<N; i++){
			exec.execute(new Philosopher(sticks[i], sticks[(i+1)%N], i, eatTime, thinkTime));
		}
		
	}

}
