package com.education.java.concurrency.blockingqueue;

import java.util.concurrent.TransferQueue;

public class QueueConsumer implements Runnable {
	
	private final TransferQueue<Integer> blockingQueue;
	
	public QueueConsumer(TransferQueue<Integer> blockingQueue) {
		
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		
		Integer element = blockingQueue.element();
		System.out.println(element);
		
		element = blockingQueue.peek();
		System.out.println(element);
		
		element = blockingQueue.poll();
		System.out.println(element);
		
		element = blockingQueue.remove();
		System.out.println(element);
		
		element = blockingQueue.remove();
		System.out.println(element);
		
		try {
			element = blockingQueue.take();
			System.out.println(element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
	}
}
