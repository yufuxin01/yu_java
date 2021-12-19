package com.yu.case6;

import java.util.Random;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Deposit
 * @description：
 * @date 2017/12/20 10:12
 */
public class Deposit implements Runnable{

    private Account account;

    private int deposit;

    public void deposit(Account account, int deposit) {
        this.account = account;
        this.deposit = deposit;
    }


    @Override
	public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {

            if (account.getAmount().get() < 20000) {
                boolean isFlag = account.deposit(threadName, deposit);
                if (!isFlag) {
                    break;
                }
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (account.getAmount().get() >= 20000) {
                break;
            }
                if (account.getAmount().get() == 0) {
                    System.out.println("余额为零，存款结束");
                    break;
                }
        }
    }

}
