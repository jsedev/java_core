package com.education.java.generics.task2;

import java.util.List;

public class Container<T> {

	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public void copy(List<? extends Product> src, List<? super Product> dest) {

		for (Product p : src) {
			dest.add(p);
		}
	}
}
