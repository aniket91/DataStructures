package com.osfg.questions;

import com.osfg.utils.Swapper;

/**
 * 
 * @author athakur
 * Question : String Permutation
 */
public class PrintAllStringPermutations {
	
	
	public static void pringStringPermutation(char[] array, int index) {
		
		if(index == array.length-1) {
			System.out.println(new String(array));
			return;
		}
		
		pringStringPermutation(array, index+1);
		
		for(int i=index + 1; i<array.length;i++) {
			Swapper.swap(array, index, i);
			pringStringPermutation(array, index+1);
		}
	}
	
	//main method - test
	public static void main(String args[]) {
		pringStringPermutation("abc".toCharArray(),0);
	}

}
