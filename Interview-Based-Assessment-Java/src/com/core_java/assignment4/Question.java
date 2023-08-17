package com.core_java.assignment4;

import java.util.Scanner;

/*
 * Create a Java program that simulates a bank account. The program should allow
users to deposit and withdraw money, check their balance.
 * */

class BankDetails {
	private String accNo;
	private String name;
	private String accType;
	private double bankBalance;
	Scanner sc = new Scanner(System.in);

	// method to open new account
	public void openAccount() {
		System.out.print("Enter Account No: ");
		accNo = sc.next();
		System.out.print("Enter Account type: ");
		accType = sc.next();
		System.out.print("Enter Name: ");
		name = sc.next();
		System.out.print("Enter Balance: ");
		bankBalance = sc.nextDouble();
	}

	// method to display account details
	public void showAccount() {
		System.out.println("\tName of account holder :: " + name);
		System.out.println("\tAccount number         :: " + accNo);
		System.out.println("\tAccount type           :: " + accType);
		System.out.println("\tAccount Balance        :: " + bankBalance);
	}

	// method to deposit money
	public void deposit() {
		double amt;
		System.out.println("Enter the amount you want to deposit: ");
		amt = sc.nextDouble();
		bankBalance = bankBalance + amt;
	}

	// method to withdraw money
	public void withdrawal() {
		double amt;
		System.out.println("Enter the amount you want to withdraw: ");
		amt = sc.nextDouble();
		if (bankBalance >= amt) {
			bankBalance = bankBalance - amt;
			System.out.println("Balance after withdrawal: " + bankBalance);
		} else {
			System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
		}
	}

	// method to search an account number
	public boolean search(String ac_no) {
		if (accNo.equals(ac_no)) {
			showAccount();
			return (true);
		}
		return (false);
	}
}

public class Question {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter number of customers opening bank account :: ");
		int n = sc.nextInt();
		BankDetails C[] = new BankDetails[n];
		for (int i = 0; i < C.length; i++) {
			C[i] = new BankDetails();
			C[i].openAccount();
		}
		int ch;
		do {
			System.out.println("\n \n***Banking System Application***");
			System.out.println(
					"1. Display all account details \n2. Search by Account number\n3. Deposit the amount \n4. Withdraw the amount \n5.Exit ");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				for (int i = 0; i < C.length; i++) {
					C[i].showAccount();
				}
				break;
			case 2:
				System.out.print("Enter account no. you want to search: ");
				String ac_no = sc.next();
				boolean found = false;
				for (int i = 0; i < C.length; i++) {
					found = C[i].search(ac_no);
					if (found) {
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 3:
				System.out.print("Enter Account no :: ");
				ac_no = sc.next();
				found = false;
				for (int i = 0; i < C.length; i++) {
					found = C[i].search(ac_no);
					if (found) {
						C[i].deposit();
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 4:
				System.out.print("Enter Account No :: ");
				ac_no = sc.next();
				found = false;
				for (int i = 0; i < C.length; i++) {
					found = C[i].search(ac_no);
					if (found) {
						C[i].withdrawal();
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 5:
				System.out.println("See you soon...");
				break;
			}
		} while (ch != 5);
		sc.close();
	}
}
