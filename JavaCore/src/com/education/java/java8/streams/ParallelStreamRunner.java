package com.education.java.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamRunner {

	public static void main(String[] args) {

		ParallelStreamRunner runner = new ParallelStreamRunner();
		// runner.sumAllElements(5);
		runner.sumAllElementsIntRanged(5);
		runner.sumAllElementsRanged(6);
	}

	private void sumAllElements(int n) {

		List<Integer> list = Stream.iterate(0, i -> i + 1).limit(n).collect(Collectors.toList());
		System.out.println("Original list: " + list);

		Integer sum = list.stream().parallel().reduce(0, Integer::sum);
		System.out.println("sum = " + sum);
	}

	private void sumAllElementsIntRanged(int n) {

		long start = System.nanoTime();

		long sum = IntStream.rangeClosed(0, n).parallel().reduce(0, Integer::sum);
		System.out.println("sum = " + sum);

		System.out.println("sumAllElementsIntRanged(), Duration: " + (System.nanoTime() - start) / 1_000_000 + " msecs");
	}

	private void sumAllElementsRanged(int n) {

		long start = System.nanoTime();
		
		Integer sum = Stream.iterate(0, i -> i + 1).limit(n).reduce(0, Integer::sum);
		System.out.println("sum = " + sum);

		System.out.println("sumAllElementsRanged(), Duration: " + (System.nanoTime() - start) / 1_000_000 + " msecs");
	}
}
