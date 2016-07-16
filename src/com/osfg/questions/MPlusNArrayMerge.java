package com.osfg.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.osfg.factory.DSFactory;

/**
 * 
 * @author athakur
 *
 *	Question :  There are two sorted arrays. First one is of size m+n containing only m elements. 
 *	Another one is of size n and contains n elements. 
 *	Merge these two arrays into the first array of size m+n such that the output is sorted.
 */
public class MPlusNArrayMerge {
	
	public static void mergeAndSortArrays(int[] mPlusNArray, int[] nArray ) {
		
		//for simplicity this code assumes all values are non negative and
		// array positions which have -1 are considered to be empty - n positions will be like this
		
		//1. Move m sorted elements to the end of m+n array
		
		int trackMelements = mPlusNArray.length-1;
		for (int i=mPlusNArray.length-1;i>=0;i--) {
			if(mPlusNArray[i] != -1) {
				mPlusNArray[trackMelements] = mPlusNArray[i];
				trackMelements--;
			}
		}
		
		System.out.println("mPlusNArray : " + Arrays.toString(mPlusNArray));
		System.out.println("nArray : " + Arrays.toString(nArray));
		
		if(trackMelements != nArray.length-1) {
			throw new RuntimeException("mPlusNArray does not have m elements");
		}
		
		System.out.println("trackMelements : "  + trackMelements);
		
		//1. now sort for parallely
		
		int mPlusNIndex = trackMelements + 1; //tracks elements of m+n array
		int nIndex = 0;	//tracks elements of n array
		
		//compare and start adding from beginning
		for(int i = 0;i<mPlusNArray.length;i++) {
			
			if(mPlusNIndex > mPlusNArray.length-1){
				mPlusNArray[i] = nArray[nIndex];
				nIndex++;
			}
			else if(nIndex > nArray.length-1) {
				mPlusNArray[i] = mPlusNArray[mPlusNIndex];
				mPlusNIndex++;
			}
			else {
				if(mPlusNArray[mPlusNIndex] < nArray[nIndex]) {
					mPlusNArray[i] = mPlusNArray[mPlusNIndex];
					mPlusNIndex++;
				}
				else {
					mPlusNArray[i] = nArray[nIndex];
					nIndex++;
				}
			}
			

		}
		
	}
	
	public static void main(String args[]) {
		
		int[] mPlusNArray = DSFactory.getArray(true, 10, 100);
		int[] nArray = DSFactory.getArray(true, 4, 100);
		Random random = new Random();
		
		//mPlusNArray should have just 6 elements. So randomly set 4 elements to -1
		
		int elementsRemaining = 4;
		List<Integer> elementsResetPosition = new ArrayList<Integer>();
		while(elementsRemaining != 0) {
			int indexToReset =  random.nextInt(10);
			if(!elementsResetPosition.contains(indexToReset)) {
				mPlusNArray[indexToReset] = -1;
				elementsResetPosition.add(indexToReset);
				elementsRemaining--;
			}
		}
		
		//primnt arrays
		System.out.println("mPlusNArray : " + Arrays.toString(mPlusNArray));
		System.out.println("nArray : " + Arrays.toString(nArray));
		
		mergeAndSortArrays(mPlusNArray, nArray);
		
		System.out.println("Sorted and Megrged Array :" +  Arrays.toString(mPlusNArray));
		
	}

}
