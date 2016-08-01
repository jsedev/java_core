package com.education.java.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamRunner {

	public static void main(String[] args) {

		ParallelStreamRunner runner = new ParallelStreamRunner();
		runner.sumAllElements(5);
	}

	private void sumAllElements(int n) {

		List<Integer> list = Stream.iterate(0, i -> i + 1).limit(n).collect(Collectors.toList());
		System.out.println("Original list: " + list);
		
		Integer sum = list.stream().parallel().reduce(0, Integer::sum);
		System.out.println("sum = " + sum);
	}
}
