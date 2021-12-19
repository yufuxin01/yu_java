package com.alonginfo.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;


class EvenChecker implements Runnable{
	private IntGenerator generator;

	public EvenChecker(IntGenerator generator) {
		super();
		this.generator = generator;
	}


	public void run() {
		// TODO Auto-generated method stub
		int val = 0;
		while (!generator.isCanceled()){
			val = generator.next();
			if (val%2 != 0){
				System.out.println("Error info --->" + val + " not even, threadInfo=" + Thread.currentThread().getName());
				generator.cancel();
			}
		}
	}
	
	public static void  test(IntGenerator gp, int count) {
		System.out.println("start test " + count + "  thread") ;
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i=0; i<count; i++){
			exec.execute(new EvenChecker(gp));
		}
		exec.shutdown();
	}
	
	public static void  test(IntGenerator gp) {
		test(gp, 5);
	}

}//end of "class EventChecker"


class IntGenerator {
	private int currentEvenValue = 0;
	private volatile boolean canceled = false;
	
	/**
	 * 对于顺序执行的程序，该方法内的 currentEvenValue 的值每次都增加2，所以 该方法的返回值用于都为偶数，不可能为奇数。 
	 * @return
	 */
	public  int next(){
		++currentEvenValue;
//		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	public void cancel(){
		canceled = true;
	}
	public boolean isCanceled(){
		return canceled;
	}
}//end of "class IntGenerator"


public class EvenTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenChecker.test(new IntGenerator());
	}

}
