package com.osfg.questions;

/**
 * 
 * @author athakur
 * Question : Verify if a string is a rotated palindrome
 * 
 * Rotated palindrome is a plaindrome which is rotated at some index so that some chars from end 
 * are moved to the start. Eg abba is a plaindrome  aabb is a rotated palindrome
 */
public class RotatedPalindrome {
	
	/**
	 * 
	 * @param str
	 * @return is str is palindrome string or not
	 */
	public static boolean isPalindrome(String str) {
		
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param str
	 * @return is str is rotated palindrome string or not
	 */
	public static boolean isRotatedPalindrome(String str) {
		
		for(int i=0;i<str.length();i++) {
			
			String left = str.substring(0, i);
			String right = str.substring(i);
			if(isPalindrome(right + left)) {
				return true;
			}			
		}
		return false;
	}
	
	// main method - tests
	public static void main(String args[]) {
		
		System.out.println(isRotatedPalindrome("aabb"));
		System.out.println(isRotatedPalindrome("abcd"));
		
	}
	

}
