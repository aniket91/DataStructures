package com.osfg.questions;

/**
 * 
 * @author athakur
 * Question : Convert a double number to rational
 * Eg 0.125 -> 1/8
 */
public class DoubleToRational {
	
	public static String getRational(double no) {
		int tenPower = 10;
		while(no*tenPower - (int)(no*tenPower) != 0) {
			tenPower = tenPower * 10;
		}
		
		int divident = (int)(no*tenPower);
		int divisor = tenPower;
		
		int gcd = GCDFinder.findGCD(divident, divisor);
		divident = divident / gcd;
		divisor = divisor / gcd;
		return divident + "/" + divisor;
	}
	
	//main method - tests
	public static void main(String args[]) {
		System.out.println(getRational(0.125));
		System.out.println(getRational(0.5));
	}
	
	

}
