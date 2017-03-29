package com.education.java.concurrency.atomicvariables;

public class Counter {

	private int count;

	public void increment() {

		count++;
	}

	public int getCount() {
		return count;
	}
}
