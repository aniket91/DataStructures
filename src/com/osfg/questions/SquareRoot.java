package com.osfg.questions;

/**
 * 
 * @author athakur
 * Question : Get Square Root of a given number
 */
public class SquareRoot {
	
	/**
	 * 
	 * @param data
	 * @return square root of data
	 */
	public static double sqrt(double data) {
		
		if(data < 0) {
			return -1;
		}
		else if(data == 0 || data ==1) {
			return data;
		}
		
		double start = 0;
		double end = data;
		double precision = 0.00001;
		
		if(data <1 ) {
			end = 1;
		}
		
		while(end - start > precision) {
			double mid  = (start + end) / 2;
			double sqr = Math.pow(mid, 2);
			if(sqr == data) {
				return mid;
			}
			else if (sqr < data) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		return (start+end)/2;
		
	}
	
	//Main method - tests
	public static void main(String args[]) {
		
		System.out.println("Square root of 9 : " + sqrt(9));
		System.out.println("Square root of 100 : " + sqrt(100));
		System.out.println("Square root of 81 : " + sqrt(81));
		System.out.println("Square root of 24 : " + sqrt(24));
		System.out.println("Square root of 1 : " + sqrt(1));
		
	}

}
