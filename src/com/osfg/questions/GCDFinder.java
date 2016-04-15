package com.osfg.questions;

/**
 * 
 * @author athakur
 *	Question : Finding GCD of two numbers
 */
public class GCDFinder {

	/**
	 * recurssive approach
	 * @param a
	 * @param b
	 * @return gcd of a and b
	 */
	public static int findGCD(int a, int b) {
		
		int remainder = a % b;
		
		if(remainder == 0) {
			return b;
		}
		else {
			return findGCD(b, remainder);
		}
		
	}
	
	public static void main(String args[]) {
		System.out.println("GCD of 10 and 4 : " + findGCD(10,4));
		System.out.println("GCD of 100 and 10: " + findGCD(100,10));
		System.out.println("GCD of 3 and 9 : " + findGCD(3,9));
		System.out.println("GCD of 11 and 24 : " + findGCD(11,24));
	}
	
	
}
