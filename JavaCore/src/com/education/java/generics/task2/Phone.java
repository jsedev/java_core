package com.education.java.generics.task2;

public class Phone extends Product<Phone> {
	
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	protected int deepCompare(Phone p) {		
		return -1;
	}
}
