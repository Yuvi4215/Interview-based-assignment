package com.core_java.assignment10;

import java.util.Scanner;
/*Write a Java program that reads a set of integers from the user and stores them in a
List. The program should then find the second largest and second smallest elements
in the List.*/
public class Question {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n; 
		System.out.println("Enter the size of the array.");
		n = sc.nextInt(); 
		int arr[] = new int[n]; 
		System.out.println("Enter the array.");
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the element for index : "+(i+1));
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++) 
			{
				if (arr[i] < arr[j]) 
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println("Second Largest element is " + arr[1]);
		System.out.println("Second Smallest element is " + arr[n - 2]);
	sc.close();
	}
}
