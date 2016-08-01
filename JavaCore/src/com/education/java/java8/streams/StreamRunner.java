package com.education.java.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {	
	
	public static void main(String[] args) {
		
		StreamRunner runner = new StreamRunner();
		runner.sumAllElements(4);
	}
	
	private void sumAllElements(int n){
		
		List<Integer> list = Stream.iterate(0, i -> i+1).limit(n).collect(Collectors.toList());
		System.out.println("Original list: " + list);
		
		long sum = list.stream().reduce(0, Integer::sum);
		System.out.println("sum = " + sum);
	}
}
