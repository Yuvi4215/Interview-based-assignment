package com.core_java.assignment7;

import java.util.Arrays;
import java.util.Scanner;

/*
Create a Java program that implements a binary search algorithm. The program
should accept user input for the target value and search for it in a sorted array. The
program should return the index of the target value if found or a message if not
found.
*/
public class Question {
	int binarySearch(int array[], int element, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (array[mid] == element)
				return mid;
			if (array[mid] < element)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		Question obj = new Question();
		int[] array = { 3, 4, 5, 6, 7, 8, 9 };
		int n = array.length;
		System.out.println(Arrays.toString(array));
		Scanner input = new Scanner(System.in);
		System.out.println("Enter element to be searched:");
		int element = input.nextInt();
		input.close();
		int result = obj.binarySearch(array, element, 0, n - 1);
		if (result == -1)
			System.out.println("Element Not found.");
		else
			System.out.println("Element found at index " + result);
	}
}
