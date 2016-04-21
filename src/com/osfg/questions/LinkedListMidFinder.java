package com.osfg.questions;

import com.osfg.factory.DSFactory;
import com.osfg.models.ListNode;

/**
 * 
 * @author athakur
 * Question : Find the middle element of a linked list
 * Extended Question : Find the (1/n)th element from the end of a linked list
 */
public class LinkedListMidFinder {
	
	
	/**
	 * 
	 * @param root
	 * @return center of the list
	 */
	public static ListNode findLLMid(ListNode root) {
		
		if(root == null) {
			return null;
		}
		
		ListNode current = root;
		ListNode middle = root;
		
		while(current.getNext() != null && current.getNext().getNext()!=null) {
			middle = middle.getNext();
			current = current.getNext().getNext();
		}
		
		return middle;
	}
	
	/**
	 * 
	 * @param root
	 * @param n
	 * @return (1/n)th node
	 */
	public static ListNode findoneByNth(ListNode root, int n) {
		
		if(root == null) {
			return null;
		}
		
		ListNode current = root;
		ListNode middle = root;
		
		// 0 1 2 3 4
		
		for(int i=1;current != null; i++,current=current.getNext()) {
			if(i%n == 0) {
				middle = middle.getNext();
			}
		}
		
		return middle;
	}
	
	public static void main(String args[]) {
		System.out.println(findLLMid(DSFactory.getLinkedList()).getValue());
		System.out.println(findoneByNth(DSFactory.getLinkedList(),2).getValue());
		System.out.println(findoneByNth(DSFactory.getLinkedList(),6).getValue());
	}

}
