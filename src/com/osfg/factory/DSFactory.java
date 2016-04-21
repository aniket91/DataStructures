package com.osfg.factory;

import com.osfg.models.ListNode;
import com.osfg.models.BTreeNode;

/**
 * 
 * @author athakur
 * Factory class to get pre populated objects
 */
public class DSFactory {

	public static ListNode getLinkedList() {
		
		ListNode head = new ListNode(0);
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		head.setNext(first);
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		return head;
	}
	
	public static int[] getArray(boolean sorted) {
		
		if(sorted) {
			return new int[]{2, 3, 3, 7, 9, 12, 15, 15, 15};
		}
		else {
			return new int[]{15, 9, 20, 16 ,4, 1, 7};
		}
		
	}
	
	
	public static BTreeNode getBST() {
		
		BTreeNode rootNode = new BTreeNode(10);
		BTreeNode rootLeftNode = new BTreeNode(7);
		BTreeNode rootRightNode = new BTreeNode(12);
		
		rootNode.setLeft(rootLeftNode);
		rootNode.setRight(rootRightNode);
		
		rootLeftNode.setLeft(new BTreeNode(5));
		rootLeftNode.setRight(new BTreeNode(9));
		
		rootRightNode.setLeft(new BTreeNode(11));
		rootRightNode.setRight(new BTreeNode(13));
		
		return rootNode;
		
	}
	
	public static BTreeNode getBTree() {
		
		BTreeNode rootNode = new BTreeNode(1);
		BTreeNode rootLeftNode = new BTreeNode(2);
		BTreeNode rootRightNode = new BTreeNode(3);
		
		rootNode.setLeft(rootLeftNode);
		rootNode.setRight(rootRightNode);
		
		rootLeftNode.setLeft(new BTreeNode(4));
		rootLeftNode.setRight(new BTreeNode(5));
		
		rootRightNode.setLeft(new BTreeNode(6));
		rootRightNode.setRight(new BTreeNode(7));
		
		return rootNode;
		
	}
	
}
