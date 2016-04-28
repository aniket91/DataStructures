package com.osfg.questions;

import com.osfg.factory.DSFactory;
import com.osfg.models.BTreeNode;


/**
 * 
 * @author athakur
 * Question : Find the Lowest Common Ancestor (LCA) of two nodes in a Binary Tree
 */
public class LCAFinder {

	
	// main method - tests
	public static void main(String args[]) {
		BTreeNode root = DSFactory.getBTree();
		System.out.println("LCA of 4 and 5 : " + findLCA(root, 4,5));
		System.out.println("LCA of 5 and 6 : " + findLCA(root, 5,6));
		System.out.println("LCA of 6 and 7 : " + findLCA(root, 6,7));
		System.out.println("LCA of 2 and 5 : " + findLCA(root, 2,5));
	}
	
	
	/**
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return LCA of n1 and n2
	 */
	public static BTreeNode findLCA(BTreeNode root, int n1, int n2) {

		if (root == null) {
			return null;
		}

		if (root.getData() == n1 || root.getData() == n2) {
			return root;
		}

		BTreeNode leftNode = findLCA(root.getLeft(), n1, n2);
		BTreeNode rightNode = findLCA(root.getRight(), n1, n2);

		if (leftNode != null && rightNode != null) {
			return root;
		}

		return leftNode != null ? leftNode : rightNode;

	}

}
