package com.yu.case9;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 */
public class TicketSeller1 implements Runnable {

	private static AtomicInteger ticketSum = new AtomicInteger(1000);

	@Override
	public void run() {
		int count;
		while ((count = ticketSum.decrementAndGet()) >= 0) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖出了第" + ++count + "张票");

		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new TicketSeller1(), "一号窗口");
		Thread t2 = new Thread(new TicketSeller1(), "二号窗口");
		Thread t3 = new Thread(new TicketSeller1(), "三号窗口");
		Thread t4 = new Thread(new TicketSeller1(), "四号窗口");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
