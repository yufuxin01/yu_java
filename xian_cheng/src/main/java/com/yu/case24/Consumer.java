package com.yu.case24;


import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue sharedQueue;
	 
    public Consumer (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    
    @Override
    public void run() {
    	
    	  while(true){
            try {
            	Thread.sleep(100);
                try {
					System.out.println("Guests Consumed: "+ sharedQueue.take()+" dish ");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            } catch (InterruptedException ex) {
            	 System.out.println(ex);
            }
    	    }
            	 

    }
    }

