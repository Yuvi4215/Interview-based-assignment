package com.core_java.assignment9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*Write a Java program that implements a producer-consumer model using
multithreading. The program should have a producer thread that generates random
numbers and adds them to a queue, and a consumer thread that reads numbers
from the queue and calculates their sum. The program should use synchronization to
ensure that the queue is accessed by only one thread at a time.*/


public class Question {
    private static final int MAX_CAPACITY = 10;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        private Random random = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void produce() throws InterruptedException {
            synchronized (queue) {
                while (queue.size() >= MAX_CAPACITY) {
                    System.out.println("Queue is full. Waiting for the consumer to consume...");
                    queue.wait();
                }

                int num = random.nextInt(100);
                queue.add(num);
                System.out.println("Produced: " + num);

                queue.notifyAll();
                Thread.sleep(1000); // Simulate some processing time before producing the next number
            }
        }
    }

    static class Consumer implements Runnable {
    	int sum = 0;

    	@Override
        public void run() {
            while (true) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consume() throws InterruptedException {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty. Waiting for the producer to produce...");
                    queue.wait();
                }

                while (!queue.isEmpty()) {
                    int num = queue.poll();
                    System.out.println("Consumed: " + num);
                    sum += num;
                }

                System.out.println("Sum of consumed numbers: " + sum);
                queue.notifyAll();
                Thread.sleep(500); // Simulate some processing time before consuming the next numbers
            }
        }
    }
}
