package com.core_java.assignment6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Write a Java program that uses stream api to perform operations on a large data set,
such as sorting or filtering the data.*/

public class Question {

	public static void main(String[] args) {
		// automatic creation of a large data set of integers.
		List<Integer> dataSet = Stream.generate(() -> (int) (Math.random() * 1000)).limit(1000)
				.collect(Collectors.toList());

		System.out.println("Original data set: " + dataSet);

		// Filtering: Keep only even numbers.
		List<Integer> evenNumbers = dataSet.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

		System.out.println("Even numbers: " + evenNumbers);

		// Sorting in ascending order.
		List<Integer> sortedAscending = dataSet.stream().sorted().collect(Collectors.toList());

		System.out.println("Sorted in ascending order: " + sortedAscending);

		// Sorting in descending order.
		List<Integer> sortedDescending = dataSet.stream().sorted((num1, num2) -> num2.compareTo(num1))
				.collect(Collectors.toList());

		System.out.println("Sorted in descending order: " + sortedDescending);
	}

}
