package com.education.java.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamRunner {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();

		initializeList(myList);

		System.out.println("Original list: " + myList);

		findMinValue(myList);
		findMaxValue(myList);
		printSortedList(myList);
		printOddValues(myList);
		printOddValuesGreaterThanFive(myList);
		sumAllElements(myList);		
	}

	private static void findMinValue(List<Integer> list) {

		// Obtain stream
		Stream<Integer> stream = list.stream();

		// min value
		Optional<Integer> minVal = stream.min(Integer::compare);

		if (minVal.isPresent()) {
			System.out.println("Min value: " + minVal.get());
		}
	}

	private static void findMaxValue(List<Integer> list) {

		Stream<Integer> stream = list.stream();
		Optional<Integer> maxValue = stream.max(Integer::compare);

		if (maxValue.isPresent()) {
			System.out.println("Max value: " + maxValue.get());
		}
	}

	private static void printSortedList(List<Integer> list) {

		Stream<Integer> sortedStream = list.stream().sorted();

		System.out.print("Sorted stream: ");
		sortedStream.forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	private static void printOddValues(List<Integer> list) {

		Stream<Integer> stream = list.stream();
		Stream<Integer> oddStream = stream.sorted().filter(x -> (x % 2) == 1);

		System.out.print("Odd values: ");
		oddStream.forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	private static void printOddValuesGreaterThanFive(List<Integer> list) {

		Stream<Integer> stream = list.stream();
		Stream<Integer> sortedStream = stream.filter(x -> (x % 2) == 1).filter(x -> x > 5).sorted();

		System.out.print("Odd values greater than five: ");
		sortedStream.forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	private static void initializeList(List<Integer> list) {

		list.add(3);
		list.add(5);
		list.add(1);
		list.add(7);
		list.add(2);
		list.add(4);
		list.add(6);
	}

	private static void sumAllElements(List<Integer> list) {

		Stream<Integer> stream = list.stream();
		long sum = stream.reduce(0, Integer::sum);
		System.out.println("sum = " + sum);
	}
}
