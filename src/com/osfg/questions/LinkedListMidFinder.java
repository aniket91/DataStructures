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
	public static ListNode<Integer> findLLMid(ListNode<Integer> root) {
		
		if(root == null) {
			return null;
		}
		
		ListNode<Integer> current = root;
		ListNode<Integer> middle = root;
		
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
	public static ListNode<Integer> findoneByNth(ListNode<Integer> root, int n) {
		
		if(root == null) {
			return null;
		}
		
		ListNode<Integer> current = root;
		ListNode<Integer> middle = root;
		
		// 0 1 2 3 4
		
		for(int i=1;current != null; i++,current=current.getNext()) {
			if(i%n == 0) {
				middle = middle.getNext();
			}
		}
		
		return middle;
	}
	
	public static void main(String args[]) {
		System.out.println(findLLMid(DSFactory.getNumericLinkedList()).getValue());
		System.out.println(findoneByNth(DSFactory.getNumericLinkedList(),2).getValue());
		System.out.println(findoneByNth(DSFactory.getNumericLinkedList(),6).getValue());
	}

}
