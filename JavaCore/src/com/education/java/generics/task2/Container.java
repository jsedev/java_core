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

	public <E extends Product<E>> void copy(List<E> src, List<? super E> dest) {

		for (E p : src) {
			dest.add(p);
		}
	}
}
