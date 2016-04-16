package com.osfg.utils;

import java.util.LinkedList;
import java.util.Queue;

import com.osfg.models.BTreeNode;

/**
 * 
 * @author athakur
 * Class to print pre order, post order, in order and level order btree traversals
 */
public class BTreePrinter {
	
	//Root - Left - Right
	public static void printPreOrderTraversal(BTreeNode root){
		if(root != null)
			System.out.println(root.getData());
		
		if(root.getLeft() != null)
			printPreOrderTraversal(root.getLeft());
		if(root.getRight() != null)
			printPreOrderTraversal(root.getRight());
	}
	
	//Left - Right - Root
	public static void printPostOrderTraversal(BTreeNode root){
		if(root.getLeft() != null)
			printPostOrderTraversal(root.getLeft());
		if(root.getRight() != null)
			printPostOrderTraversal(root.getRight());
		if(root != null)
			System.out.println(root.getData());
	}
	
	//Left - Root - Right
	public static void printInOrderTraversal(BTreeNode root){
		if(root.getLeft() != null)
			printInOrderTraversal(root.getLeft());
		
		if(root != null)
			System.out.println(root.getData());
		
		if(root.getRight() != null)
			printInOrderTraversal(root.getRight());
		
	}
	
	private static Queue<BTreeNode> levelOrderQueue = new LinkedList();
	
	public static void printLevelOrderTraversal(BTreeNode root){
		
		if(root == null) {
			return;
		}
		
		System.out.println(root.getData());
		
		if(root.getLeft() != null)
			levelOrderQueue.offer(root.getLeft());
	
		if(root.getRight() != null)
			levelOrderQueue.offer(root.getRight());
		
		if(!levelOrderQueue.isEmpty()) {
			printLevelOrderTraversal(levelOrderQueue.poll());
		}
		else {
			levelOrderQueue.clear();
		}
		
		
	}
	
}
