package com.osfg.questions;

import com.osfg.factory.DSFactory;
import com.osfg.models.ListNode;

/**
 * @author athakur
 *
 *	Interview question for LinkedList reversal
 */
public class LinkedListReversal {
	
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
	
	public static void main(String args[]) {
		
		ListNode linkedList = DSFactory.getLinkedList();
		System.out.println("Original Linked List : " + linkedList);
		ListNode iterativeReverse = getReverseLinkedListIterative(linkedList);
		System.out.println("Iterative Revered Linked List : " + iterativeReverse);
		ListNode recursiveReverse = getReverseLinkedListRecursive(iterativeReverse);
		System.out.println("Recursive Linked List : " + recursiveReverse);
	}
	
	

}
