package com.osfg.questions;

import com.osfg.factory.DSFactory;

/**
 * 
 * @author athakur
 * Question : Count Occurance of a given number in sorted array
 */
public abstract class SortedOccurenceCounter {
	
	/**
	 * Linear approach. Complexity O(N)
	 * @param array
	 * @param data
	 * @return
	 */
	public static int getOccurenceLinear(int[] array, int data) {
		if(array == null)
			return 0;
		
		int occurence = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i] == data) {
				occurence++;
			}
		}
		return occurence;
	}
	
	/**
	 * Complexity O(log(N))
	 * @param array
	 * @param data
	 * @return
	 */
	public static int getOccurenceLogarithmic(int[] array, int data, int startIndex, int endIndex) {
		
		if(startIndex > endIndex) {
			return 0;
		}
		
		if(array[startIndex] > data || array[endIndex] < data) {
			return 0;
		}
		
		if(array[startIndex] == data && array[endIndex] == data) {
			return endIndex - startIndex + 1;
		}
		
		int mid = startIndex + (endIndex - startIndex)/2;
		
		if(array[mid] > data) {
			return getOccurenceLogarithmic(array, data, startIndex, mid - 1);
		}
		else if(array[mid] < data) {
			return getOccurenceLogarithmic(array, data, mid + 1, endIndex);
		}
		else {//array[mid] == data
			return 1 + getOccurenceLogarithmic(array, data, startIndex, mid - 1) + getOccurenceLogarithmic(array, data, mid + 1, endIndex); 
		}
		
		
	}
	
	
	//main method - tests
	public static void main(String args[]) {
		
		int[] sortedArray = DSFactory.getArray(true);
		System.out.println("Occurence of 15(Linear) : " + getOccurenceLinear(sortedArray, 15));
		System.out.println("Occurence of 3(Linear) : " + getOccurenceLinear(sortedArray, 3));
		System.out.println("Occurence of 0(Linear) : " + getOccurenceLinear(sortedArray, 0));
		
		System.out.println("Occurence of 15(Log) : " + getOccurenceLogarithmic(sortedArray, 15, 0, sortedArray.length - 1));
		System.out.println("Occurence of 3(Log) : " + getOccurenceLogarithmic(sortedArray, 3, 0, sortedArray.length - 1));
		System.out.println("Occurence of 0(Log) : " + getOccurenceLogarithmic(sortedArray, 0, 0, sortedArray.length - 1));
		
	}

}
