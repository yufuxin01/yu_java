package com.yu.case6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huanglaoxie(微信 : yfct - 8888)
 * @className Account
 * @description：
 * @date 2017/12/20 10:11
 */
public class Account {

	private AtomicInteger amount;

	private String name;

	public void name() {
		System.out.println("账户为：" + name + "!");
	}

	public synchronized boolean deposit(String threadName, int change) {
		amount.addAndGet(change);
		if (amount.get() > 20000) {
			System.out.print("存款金额已经达到上限，存款失败");
			return false;
		}
		System.out.println("01：" + threadName + ",存款金额为" + change + ",开始存款，存款后余额为" + amount);
		return true;
	}

	public synchronized boolean withdraw(String threadName, int money) {
		if (amount.get() <= 0 || amount.get() < money) {
			System.out.println(threadName + ",账户金额为" + amount.get() + "，你的取款金额为" + money + "，取款失败");
			return false;
		} else {
			amount.addAndGet(-money);
			System.out.println("02：" + threadName + ",取款金额为" + money + ",开始取款，取款后余额为" + amount);
			return true;
		}
	}

	public void openAccount(String name, Integer money) {
		this.name = name;
		this.amount = new AtomicInteger(money);
		System.out.println("00：" + name + "开户成功,开户金额为" + money);
	}

	public AtomicInteger getAmount() {
		return amount;
	}

	public void setAmount(AtomicInteger amount) {
		this.amount = amount;
	}
}
