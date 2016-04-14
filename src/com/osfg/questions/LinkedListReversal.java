package com.osfg.questions;

import com.osfg.factory.DSFactory;
import com.osfg.models.ListNode;

/**
 * @author athakur
 *
 *	Question : Reverse a Linked List
 */
public class LinkedListReversal {
	
	/**
	 * Iterative approach
	 * @param originalList
	 * @return reversed linked list
	 */
	public static ListNode getReverseLinkedListIterative(ListNode originalList) {
		
		if(originalList == null || originalList.getNext() == null) {
			return originalList;
		}
		
		ListNode currNode = originalList;
		ListNode nextNode = currNode.getNext();
		currNode.setNext(null);
		
		
		while(nextNode != null) {
			ListNode tempNode = nextNode.getNext();
			nextNode.setNext(currNode);
			currNode = nextNode;
			nextNode = tempNode;
		}
		
		return currNode;
		
	}
	
	/**
	 * Recursive approach
	 * @param originalList
	 * @return reversed linked list
	 */
	public static ListNode getReverseLinkedListRecursive(ListNode originalList) {
		
		if(originalList == null || originalList.getNext() == null) {
			return originalList;
		}
		
		ListNode remainingRevers = getReverseLinkedListRecursive(originalList.getNext());
		ListNode curr = remainingRevers;
		
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}
		
		curr.setNext(originalList);
		originalList.setNext(null);
		return remainingRevers;
		
	}	
	
	//Main method - tests
	public static void main(String args[]) {
		
		ListNode linkedList = DSFactory.getLinkedList();
		System.out.println("Original Linked List : " + linkedList);
		ListNode iterativeReverse = getReverseLinkedListIterative(linkedList);
		System.out.println("Iterative Revered Linked List : " + iterativeReverse);
		ListNode recursiveReverse = getReverseLinkedListRecursive(iterativeReverse);
		System.out.println("Recursive Linked List : " + recursiveReverse);
	}
	
	

}
