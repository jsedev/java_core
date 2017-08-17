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
			
			blockingQueue.transfer(3);
			
			boolean isConsumed = blockingQueue.tryTransfer(4);
			System.out.println(isConsumed);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}	
}
