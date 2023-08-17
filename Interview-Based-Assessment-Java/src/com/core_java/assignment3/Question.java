package com.core_java.assignment3;

import java.util.Scanner;

/*
 * Write a Java programme that takes an integer from the user and throws an exception
if it is negative.Demonstrate Exception handling of same program as solution.
 * */

class MyException extends Exception{
 private static final long serialVersionUID = 1L;

public MyException(String message){
  System.out.println(message);
 
}
}


public class Question {
	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter number.");
			 int num = sc.nextInt();
			   if(num < 0)
			    throw new MyException("Number is negative");
			   else
				   System.out.println("Enterd number is :: "+num);
		}   catch (MyException m) {
			   System.out.println(m);
		  } catch (java.util.InputMismatchException e) {
	            System.out.println("Exception: Invalid input. Please enter an integer.");
	        } finally {
	            sc.close();
	        }
	}
}
