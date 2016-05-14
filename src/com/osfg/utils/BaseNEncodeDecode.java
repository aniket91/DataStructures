package com.osfg.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author athakur
 * Class to convert an integer to base N representation and vice versa
 */
public class BaseNEncodeDecode {
	
	public static List<Integer> encode(int number, int baseN) {
		List<Integer> baseNEncodedList = new ArrayList<>();
		
		while(number > 0) {
			baseNEncodedList.add(0, number%baseN);
			number = number / baseN;
		}
		return baseNEncodedList;
	}
	
	public static int decode(List<Integer> baseNEncodedList, int baseN) {
		int number = 0;
		for(int data : baseNEncodedList) {
			number = number * baseN + data;
		}
		return number;
	}
	
	//tests to verify encode decode
	public static void main(String args[]) {
		
		List<Integer> base2Data = encode(42,2);
		System.out.println(base2Data);
		System.out.println(decode(base2Data,2));
		
	}
	
}
