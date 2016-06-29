package com.education.java.generics;

import java.util.Arrays;
import java.util.List;

public class GenericsRunner {

	public static void main(String[] args) {

		correctExample();

		// classCastExceptionExample();
	}

	private static void correctExample() {

		// since SomeType class is parameterized, compiler will apply generics
		// for methods as well.
		SomeType<Object> someType = new SomeType<>();
		List<String> list = Arrays.asList("value");
		someType.test(list);
	}

	private static void classCastExceptionExample() {

		// since generic type is not provided, all generic methods are ignored -
		// these methods accept Object type (i.e. Collection<Object>)!!!
		SomeType someType = new SomeType();
		List<String> list = Arrays.asList("value");

		// Generics are checked by compiler only.
		// Although next line of code is correct for compiler (because of
		// comment above),an exception will be thrown at runtime.
		// ClassCastException will be thrown here.
		someType.test(list);
	}
}