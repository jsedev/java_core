package com.education.java.concurrency.blockingqueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueRunner {
	
	private final TransferQueue<Integer> blockingQueue;
	
	private final QueuePopulator populator;
	
	private final QueueConsumer consumer;
	
	public LinkedTransferQueueRunner() {
		
		blockingQueue = new LinkedTransferQueue<>();
		
		populator = new QueuePopulator(blockingQueue);
		consumer = new QueueConsumer(blockingQueue);
	}	

	public static void main(String[] args) throws InterruptedException {
		
		LinkedTransferQueueRunner runner = new LinkedTransferQueueRunner();
		 
		Thread populatorThread = new Thread(runner.populator);
		Thread consumerThread = new Thread(runner.consumer);
		
		populatorThread.start();
		consumerThread.start();
		
		populatorThread.join();
		consumerThread.join();
		
		System.out.println("Done.");
	}
}
