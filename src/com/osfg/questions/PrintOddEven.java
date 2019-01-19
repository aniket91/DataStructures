package com.osfg.questions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

/**
 * 
 * @author athakur
 * Question:  Print even and odd numbers using two threads.
 * Print the numbers in order, while one thread only prints the even numbers and the other thread only prints the odd numbers. 
 */
public class PrintOddEven {

	public static void main(String args[]) throws InterruptedException, ExecutionException {

		System.out.println("****With Sempahores*********");
		withSemaphores();
		Thread.sleep(5000);
		System.out.println("****With Watch and Notify*********");
		withWatchNotify();

	}

	public static void withWatchNotify() {

		Object oddLock = new Object();
		Object evenLock = new Object();

		Runnable printOdd = () -> {
			for (int i = 1; i < 10; i = i + 2) {
				if (i != 1) {
					synchronized (oddLock) {
						try {
							oddLock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
				synchronized (evenLock) {
					evenLock.notify();
				}
			}
		};

		Runnable printEven = () -> {
			for (int i = 2; i < 10; i = i + 2) {
				synchronized (evenLock) {
					try {
						evenLock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(i);
				synchronized (oddLock) {
					oddLock.notify();
				}
			}
		};

		new Thread(printOdd).start();
		new Thread(printEven).start();
	}

	public static void withSemaphores() throws InterruptedException, ExecutionException {

		Semaphore oddLock = new Semaphore(1);
		Semaphore evenLock = new Semaphore(0);

		Runnable printOdd = () -> {
			for (int i = 1; i < 10; i = i + 2) {
				try {
					oddLock.acquire();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;
				System.out.println(i);
				evenLock.release();
			}
		};

		Runnable printEven = () -> {
			for (int i = 2; i < 10; i = i + 2) {
				try {
					evenLock.acquire();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
				oddLock.release();

			}
		};

		new Thread(printOdd).start();
		new Thread(printEven).start();
	}

}
