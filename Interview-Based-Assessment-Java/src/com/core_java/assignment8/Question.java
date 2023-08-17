package com.core_java.assignment8;

/*Write a Java program that creates two threads. The first thread should print even
numbers between 1 and 10, and the second thread should print odd numbers
between 1 and 10.*/

public class Question {
	int counter = 1;
	static int N;

	public void printOddNumber() {
		synchronized (this) {
			while (counter < N) {
				while (counter % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(counter + " ");
				counter++;
				notify();
			}
		}
	}

	public void printEvenNumber() {
		synchronized (this) {
			while (counter < N) {
				while (counter % 2 == 1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(counter + " ");
				counter++;
				notify();
			}
		}
	}

	public static void main(String[] args) {
		N = 10;
		Question mt = new Question();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				mt.printEvenNumber();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				mt.printOddNumber();
			}
		});
		t1.start();
		t2.start();
	}
}
