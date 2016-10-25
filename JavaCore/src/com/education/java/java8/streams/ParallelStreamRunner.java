package com.education.java.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamRunner {

	public static void main(String[] args) {

		ParallelStreamRunner runner = new ParallelStreamRunner();
		// runner.sumAllElements(5);
		//runner.sumAllElementsIntRanged(5);
		//runner.sumAllElementsRanged(6);
		//runner.sumAllElementsInParallel();
		runner.calcSquareRoots();
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
	
	private void sumAllElementsInParallel() {

		int lastNum = 3;

		System.out.print("Original source: ");
		
		IntStream.range(0, lastNum).forEach((x) -> {
			System.out.print(x + " ");
		});

		System.out.println();

		IntStream stream = IntStream.range(0, lastNum);

		int sum = stream.parallel().reduce(0, (a, b) -> {
			return a + b;
		});
		System.out.println("Sum: " + sum);
	}
	
	private void calcSquareRoots() {

		List<Double> originalSource = Arrays.asList(1.0, 4.0, 9.0);

		System.out.println("Original source: " + originalSource);

		double result = originalSource.parallelStream().reduce(1.0, (a, b) -> {
			return a * Math.sqrt(b);
		}, (a, b) -> {
			return a * b;
		});

		System.out.println("Result: " + result);
	}
}
