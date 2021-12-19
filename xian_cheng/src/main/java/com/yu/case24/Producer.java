package com.yu.case24;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue sharedQueue;
	 
    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=1; i<9; i++){
            System.out.println("Chefs Produced: " + i+" dish ");
                try {
					sharedQueue.put(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        }
    }
}