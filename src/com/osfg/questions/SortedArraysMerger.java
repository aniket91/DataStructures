package com.osfg.questions;

import java.util.Arrays;

/**
 * 
 * @author athakur
 * Question :  There are two sorted arrays. 
 * First one is of size m+n containing only m elements. 
 * Another one is of size n and contains n elements. 
 * Merge these two arrays into the first array of size m+n such that the output is sorted.
 */
public class SortedArraysMerger {
	
	
	/**
	 * Move all elements to the end in m+n array
	 * Assuming emty gaps have -1 and original array does not have -1
	 * @param mPlusNArray
	 */
	public static void setup(int[] mPlusNArray) {
		
		int substitutionPointer = mPlusNArray.length - 1;
		for(int i=mPlusNArray.length - 1; i>=0; i--) {
			if(mPlusNArray[i] != -1) {
				mPlusNArray[substitutionPointer] = mPlusNArray[i];
				substitutionPointer--;
			}
		}
	}
	
	public static void merge(int[] mPlusNArray, int[] nArray) {
		
		int mPlusNArrayDataStart = nArray.length;
		int nArrayStart = 0;
		int mPlusNArrayStart = 0;
		
		while(mPlusNArrayStart < mPlusNArray.length) {
			if(mPlusNArrayDataStart < mPlusNArray.length && mPlusNArray[mPlusNArrayDataStart] < nArray[nArrayStart]) {
				mPlusNArray[mPlusNArrayStart] = mPlusNArray[mPlusNArrayDataStart];
				mPlusNArrayDataStart++;
			}
			else {
				mPlusNArray[mPlusNArrayStart] = nArray[nArrayStart];
				nArrayStart++;
			}
			mPlusNArrayStart++;
		}
	}
	
	public static void main(String args[]) {
		
		int[] mPlusNArray = new int[]{2, -1, 7, -1, -1, 10, -1};
		int[] nArray = new int[]{5, 8, 12, 14};
		setup(mPlusNArray);
		System.out.println(Arrays.toString(mPlusNArray));
		merge(mPlusNArray, nArray);
		System.out.println(Arrays.toString(mPlusNArray));
		
	}
	
	

}
