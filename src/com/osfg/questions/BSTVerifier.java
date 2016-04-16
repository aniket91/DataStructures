package com.osfg.questions;

import com.osfg.factory.DSFactory;
import com.osfg.models.BTreeNode;

/**
 * 
 * @author athakur
 * Question : Verify if a binary tree is a Binary Search Tree (BST)
 */
public class BSTVerifier {
	
	
	public static boolean isBST(BTreeNode root) {
		
		if(root == null) {
			return true;
		}
		
		BTreeNode leftNode = root.getLeft();
		BTreeNode rightNode = root.getRight();
		
		if((leftNode!=null && root.getData() < leftNode.getData()) || (rightNode!=null && root.getData() > rightNode.getData())){
			return false;
		}
		else {
			return isBST(leftNode) && isBST(rightNode);
		}
		
	}
	
	public static void main(String args[]) {
		
		System.out.println(isBST(DSFactory.getBST()));
		System.out.println(isBST(DSFactory.getBTree()));
		
	}

}
