package com.osfg.questions;

import com.osfg.factory.DSFactory;

/**
 * 
 * @author athakur
 * Quesrion : Find the 1st index of a given number in a sorted array allowing duplicates
 */
public class IndexInSortedArray {
	
	/**
	 * You can use a linear search to to return first index
	 * This method uses a variation of binary search. Complexity is O(Log(N))
	 * @param array original array to search data in
	 * @param data to be searched
	 * @param start index
	 * @param end index
	 * @return index at which data occurs first
	 */
	public static int getIndex(int[] array, int data, int start, int end) {
		
		if(start > end) {
			return -1;
		}
		int mid = start + (end-start)/2;
		
		if(array[mid] == data) {
			if(array[mid-1] != data){
				return mid;
			}
			else {
				return getIndex(array, data, start, mid-1);
			}
			
		}
		else {
			if(array[mid] < data) {
				return getIndex(array, data, mid+1,end);
			}
			else {
				//array[mid] > data
				return getIndex(array, data, start,mid-1);
			}
		}
		
	}
	
	//main methods - tests
	public static void main(String args[]) {
		int[]sortedArray = DSFactory.getArray(true);
		System.out.println(getIndex(sortedArray,15,0,sortedArray.length-1));
		System.out.println(getIndex(sortedArray,3,0,sortedArray.length-1));
		System.out.println(getIndex(sortedArray,4,0,sortedArray.length-1));
	}
	

}
