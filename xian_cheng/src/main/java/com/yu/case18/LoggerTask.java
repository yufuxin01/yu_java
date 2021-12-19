package com.yu.case18;

import java.util.concurrent.TimeUnit;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className LoggerTask
 * @description：
 * @date 2017/11/25 12:41
 */
public class LoggerTask implements Runnable {

	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(500);
				Logger.asyncWriteLogs();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
