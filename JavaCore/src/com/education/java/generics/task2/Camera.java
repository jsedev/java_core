package com.education.java.generics.task2;

public class Camera extends Product<Camera> {
	
	private double pixel;

	public double getPixel() {
		return pixel;
	}

	public void setPixel(double pixel) {
		this.pixel = pixel;
	}

	@Override
	protected int deepCompare(Camera c) {
		return 0;
	}
}
