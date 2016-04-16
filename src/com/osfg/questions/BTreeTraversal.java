package com.osfg.questions;

import com.osfg.factory.DSFactory;
import com.osfg.utils.BTreePrinter;

/**
 * 
 * @author athakur
 * Question : Print BTree in pre order, post order, in order and level order
 */
public class BTreeTraversal {

	
	//main method - test
	public static void main(String args[]) {
		
		System.out.println("Pre order : ");
		BTreePrinter.printPreOrderTraversal(DSFactory.getBTree());
		System.out.println("---------------");
		
		System.out.println("Post order : ");
		BTreePrinter.printPostOrderTraversal(DSFactory.getBTree());
		System.out.println("---------------");
		
		System.out.println("In order : ");
		BTreePrinter.printInOrderTraversal(DSFactory.getBTree());
		System.out.println("---------------");
		
		System.out.println("Level order : ");
		BTreePrinter.printLevelOrderTraversal(DSFactory.getBTree());
		System.out.println("---------------");
		
	}
	
}
