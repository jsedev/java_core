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
		System.out.println("Even values are multiplied: " + multiplyEvenValues(myList));

		List<Double> myListDouble = new ArrayList<>();
		initializeDoubleList(myListDouble);

		System.out.println("Parallel Square Root Calculation: " + parellelSquareRootCalc(myListDouble));
	}

	private static void initializeList(List<Integer> list) {

		list.add(3);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(4);
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

	private static int multiplyEvenValues(List<Integer> list) {

		return list.stream().reduce(1, (x, y) -> {
			if (y % 2 == 0) {
				return x * y;
			}
			return x;
		});
	}

	private static double parellelSquareRootCalc(List<Double> list) {

		return list.parallelStream().reduce(1.0D, (x, y) -> x * Math.sqrt(y), (x, y) -> x * y);
	}

	private static void initializeDoubleList(List<Double> list) {

		list.add(1.0);
		list.add(4.0);
		list.add(9.0);
	}
}
