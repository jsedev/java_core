package com.education.java.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamReduceRunner {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();

		initializeList(myList);

		System.out.print("Original list: ");
		myList.stream().forEach(x -> System.out.print(x + " "));

		System.out.println("\nFirst reduce: " + reduceSimple(myList));
		System.out.println("Second reduce (identityVal): " + reduceIdentityVal(myList));
	}

	private static void initializeList(List<Integer> list) {

		list.add(3);
		list.add(5);
		list.add(1);
	}

	private static int reduceSimple(List<Integer> list) {

		Optional<Integer> result = list.stream().reduce((x, y) -> x * y);

		if (result.isPresent()) {
			return result.get();
		}

		return -1;
	}

	private static int reduceIdentityVal(List<Integer> list) {

		return list.stream().reduce(1, (x, y) -> x * y);
	}
}
