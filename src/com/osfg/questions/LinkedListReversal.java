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
	public static ListNode<Integer> getReverseLinkedListIterative(ListNode<Integer> originalList) {
		
		if(originalList == null || originalList.getNext() == null) {
			return originalList;
		}
		
		ListNode<Integer> currNode = originalList;
		ListNode<Integer> nextNode = currNode.getNext();
		currNode.setNext(null);
		
		
		while(nextNode != null) {
			ListNode<Integer> tempNode = nextNode.getNext();
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
	public static ListNode<Integer> getReverseLinkedListRecursive(ListNode<Integer> originalList) {
		
		if(originalList == null || originalList.getNext() == null) {
			return originalList;
		}
		
		ListNode<Integer> remainingRevers = getReverseLinkedListRecursive(originalList.getNext());
		ListNode<Integer> curr = remainingRevers;
		
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}
		
		curr.setNext(originalList);
		originalList.setNext(null);
		return remainingRevers;
		
	}	
	
	//Main method - tests
	public static void main(String args[]) {
		
		ListNode<Integer> linkedList = DSFactory.getNumericLinkedList();
		System.out.println("Original Linked List : " + linkedList);
		ListNode<Integer> iterativeReverse = getReverseLinkedListIterative(linkedList);
		System.out.println("Iterative Revered Linked List : " + iterativeReverse);
		ListNode<Integer> recursiveReverse = getReverseLinkedListRecursive(iterativeReverse);
		System.out.println("Recursive Linked List : " + recursiveReverse);
	}
	
	

}
