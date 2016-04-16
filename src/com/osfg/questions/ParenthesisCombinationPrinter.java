package com.osfg.questions;

/**
 * 
 * @author athakur
 * Question : Print all valid combinations of groups of parenthesis
 * Eg for {}{} - possible combinations '{{}}','{}{}'
 */
public class ParenthesisCombinationPrinter {
	
	public static void printParenthesis(int leftRemain, int rightRemain, String currCombination) {
		
		if(leftRemain == 0 && rightRemain == 0) {
			System.out.println(currCombination);
			return;
		}
		
		if(leftRemain > 0) {
			printParenthesis(leftRemain-1, rightRemain, currCombination + "{");
			
			if(leftRemain < rightRemain) {
				printParenthesis(leftRemain, rightRemain-1, currCombination + "}");
			}
			
		}
		else {
			//leftRemain == 0
			printParenthesis(leftRemain, rightRemain-1, currCombination + "}");
			
		}
		
	}
	
	//main method - tests
	public static void main(String args[]) {
		printParenthesis(3,3,"");
		System.out.println("-----------");
		printParenthesis(2,2,"");
	}

}
