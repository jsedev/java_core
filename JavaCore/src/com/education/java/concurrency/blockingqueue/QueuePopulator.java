package com.education.java.concurrency.blockingqueue;

import java.util.concurrent.TransferQueue;

public class QueuePopulator implements Runnable {
	
	private final TransferQueue<Integer> blockingQueue;
	
	public QueuePopulator(TransferQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		
		blockingQueue.add(1);
		
		try {
			blockingQueue.put(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}	
}
