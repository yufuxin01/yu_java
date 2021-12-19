package com.yu.case18;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Logger
 * @description：
 * @date 2017/11/25 12:41
 */
public class Logger {
	private static LinkedBlockingQueue<String> logQueue = new LinkedBlockingQueue<String>();
	private static Thread thread;
	private static  String DIR = "d:\\log\\";
	private static  String FILE_NAME = "server.log";
	private static  java.nio.file.Path path  ;

	static {
		initPath();
		initLogTask();
	}

	private static void initLogTask() {
		LoggerTask task = new LoggerTask();
		thread = new Thread(task);
		thread.start();
	}

	private static void initPath() {
		File f = new File(DIR);
		if(!f.exists()){
			f.mkdirs(); //创建目录
		}
		path = Paths.get(DIR +FILE_NAME);
	}

	public static void log(String message) {
		StringWriter writer = new StringWriter();
		writer.write(message);
		logQueue.offer(writer.toString());
	}

	public static void asyncWriteLogs() {
		String message;
		try (BufferedWriter fileWriter = Files.newBufferedWriter(path,StandardOpenOption.CREATE,
				StandardOpenOption.APPEND)) {
			while ((message = logQueue.poll()) != null) {
				StringWriter writer = new StringWriter();
				writer.write(new Date().toString());
				writer.write(": ");
				writer.write(message);
				fileWriter.write(writer.toString());
				fileWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
