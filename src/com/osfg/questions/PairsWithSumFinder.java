package com.osfg.questions;

import com.osfg.factory.DSFactory;

/**
 * 
 * @author athakur
 * Question : Print all pairs in a sorted array that sum to M
 */
public class PairsWithSumFinder {
	
	
	/**
	 * This is a recurssive approach but similar to two for loops one inside another
	 * Complexity is O(N^2) which is not good. 
	 * We are not using the fact that the array is sorted
	 * See the other method with alternate solution.
	 * @param array
	 * @param start
	 * @param sum
	 */
	public static void printPairs(int[] array, int start, int sum) {
		
		if(start >= array.length-1) {
			return;
		}
		
		for(int i=start+1; i<=array.length-1;i++) {
			if(array[start] + array[i] == sum) {
				System.out.println("(" + array[start] + "," + array[i] + ")");
			}
		}
		printPairs(array, start+1, sum);
	}
	
	/**
	 * This is a better algorithm and cosiders the fact that the array is sorted
	 * Complexity of this is O(N)
	 * However note that this also does not print duplicates
	 * Just two numbers that sum upto M
	 * @param array
	 * @param sum
	 */
	public static void printPairs(int[] array, int sum) {
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		
		while(leftIndex < rightIndex) {
			int tempSum  = array[leftIndex] + array[rightIndex];
			if(tempSum == sum) {
				System.out.println("(" + array[leftIndex] + "," + array[rightIndex] + ")");
				leftIndex++;
				rightIndex--;
			}
			else if (tempSum < 12) {
				leftIndex++;
			}
			else {
				//tempSum > 12
				rightIndex--;
			}
		}
		
		
	}
	
	public static void main(String args[]) {
		
		int[] array = DSFactory.getArray(true);
		printPairs(array, 0, 12);
		System.out.println("----------------");
		printPairs(array, 12);
	}

}
