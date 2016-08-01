package com.education.java.generics.task2;

public abstract class Product<T extends Product<T>> implements Comparable<T> {
	
	private String name;
	
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	protected abstract int deepCompare(T p);

	@Override
	public int compareTo(T o) {		
		return deepCompare(o);
	}
}
