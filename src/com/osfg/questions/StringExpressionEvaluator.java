package com.osfg.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author athakur
 * Question : Write a Pseudo code to parse a String and and evaluate expressions like:
 * (+ 5 4 6)
 * (* 2 (- 7 3) 4)
 * (+ 3 (* 5 2) (- 6 3))
 * Example:
 * (+ 5 4 6) 	->	(5 + 4 + 6) = 15
 * (* 2 (- 7 3) 4)   ->  (2 * (7 - 3) * 4) = 32
 * (+ 3 (* 5 2) (- 6 3))  -> (3 + (5 * 2) + (6 - 3)) = 16
 */
public class StringExpressionEvaluator {
	
	private static Stack<String> dataStack = new Stack<>();
	private static Stack<Character> operatorStack = new Stack<>();
	
	
	private static List<Character> operands = Arrays.asList('+','-','*','/');
	
	
	public static int parse(String input) {
		
			
		for(Character ch : input.toCharArray()) {
			if(isOperator(ch)) {
				operatorStack.push(ch);
			}
			else if(ch.equals(')')) {
				Integer value = Integer.parseInt(dataStack.pop().toString());
				while(!dataStack.peek().equalsIgnoreCase("(")) {
					value = operate(Integer.parseInt(dataStack.pop().toString()), value, operatorStack.peek());
				}
				dataStack.pop();
				operatorStack.pop();
				dataStack.push(value.toString());
			}
			else {
				dataStack.push(ch.toString());
			}
		}
		
		return Integer.parseInt(dataStack.pop().toString());
		
		
	}
	
	private static boolean isOperator(Character operator) {
		if(operands.contains(operator)) return true;
		return false;
	}

	
	
	public static int operate(int left, int right, Character operation) {
		switch(operation) {
		case '+' : 	return left + right;
		case '-' : 	return left - right;
		case '*' : 	return left * right;
		case '/' : 	return left / right;
		default : throw new RuntimeException("Operation not supported");
		}
		
	}
	
	//main method - tests
	public static void main(String args[]) {
		
		
		String test1 = "(+546)";
		String test2 = "(*2(-73)4)";
		String test3 = "(+3(*52)(-63))";
		System.out.println(parse(test3));
	}
	
	

}
