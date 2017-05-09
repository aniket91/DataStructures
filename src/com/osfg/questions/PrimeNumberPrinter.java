package com.osfg.questions;

/**
 * 
 * @author athakur 
 * Question : Given a number n, print all primes smaller than or
 *         equal to n.
 */
public class PrimeNumberPrinter {

	public static void primeNumberPrinter(int n) {

		int[] numbers = new int[n + 1];
		boolean[] primeNos = new boolean[n + 1];

		for (int i = 0; i < n; i++) {
			numbers[i] = i;
			primeNos[i] = true;
		}

		for (int i = 2; i < n; i++) {
			if (!primeNos[i]) {
				continue;
			}
			for (int j = i * 2; j < n; j = j + i) {
				primeNos[j] = false;
			}
		}

		for (int i = 2; i < n; i++) {
			if (primeNos[i]) {
				System.out.println(numbers[i]);
			}
		}

	}

	public static void main(String args[]) {

		primeNumberPrinter(20);

	}

}
