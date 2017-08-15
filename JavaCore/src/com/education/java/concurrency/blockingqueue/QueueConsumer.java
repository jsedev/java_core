package com.education.java.concurrency.blockingqueue;

import java.util.concurrent.TransferQueue;

public class QueueConsumer implements Runnable {
	
	private final TransferQueue<Integer> blockingQueue;
	
	public QueueConsumer(TransferQueue<Integer> blockingQueue) {
		
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
