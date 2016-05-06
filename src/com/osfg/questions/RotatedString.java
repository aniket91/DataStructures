package com.osfg.questions;

/**
 * 
 * @author athakur
 * Question : Verify if strings are rotations of each other or not
 */
public class RotatedString {

	public static boolean isRotation(String a, String b) {
		
		String temp  = a + a;
		if(temp.contains(b)) {
			return true;
		}
		return false;
	}
	
	// main method -tests
	public static void main(String args[]) {
		
		System.out.println(isRotation("AACD","ACDA"));
		System.out.println(isRotation("AACD","AAAA"));
		
	}
	
	
}
