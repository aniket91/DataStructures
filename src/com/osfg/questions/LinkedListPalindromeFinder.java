package com.osfg.questions;

import java.util.Stack;

import com.osfg.factory.DSFactory;
import com.osfg.models.ListNode;

/**
 * 
 * @author athakur Find if a given Singly Linked list is a palindrome or not
 */
public class LinkedListPalindromeFinder {

	/**
	 * Method 1 : Put all Linked List values in a Stack. Iterate again and
	 * compare values from head of lost to the top of stack. Time Complexity :
	 * O(N) Space Complexity : O(N)
	 * 
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode<String> head) {
		boolean isPanindrome = true;

		Stack<String> stack = new Stack<>();
		ListNode<String> currentNode = head;

		while (currentNode != null) {
			stack.push(currentNode.getValue());
			currentNode = currentNode.getNext();
		}

		currentNode = head;
		while (currentNode != null) {
			if (!currentNode.getValue().equals(stack.pop())) {
				isPanindrome = false;
				break;
			}
			currentNode = currentNode.getNext();
		}
		return isPanindrome;
	}

	/**
	 * Method 1 : Find the mid. Reverse second half and check. Time Complexity :
	 * O(N) Space Complexity : O(1)
	 * 
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome2(ListNode<String> head) {
		boolean isPanindrome = true;

		ListNode<String> fastPoiner = head;
		ListNode<String> slowPointer = head;
		ListNode<String> slowPointerPrev = head;

		while (fastPoiner != null && fastPoiner.getNext() != null) {
			slowPointerPrev = slowPointer;
			slowPointer = slowPointer.getNext();
			fastPoiner = fastPoiner.getNext().getNext();
		}

		if (fastPoiner != null) {
			// linked list had odd elements we can loose the middle element
			slowPointer = slowPointer.getNext();
		}

		// split two halved
		// for odd elements case scenario we completely loose the middle element
		slowPointerPrev.setNext(null);

		// store mid. We will use this to detach 1st half once we have revered
		// 2nd half
		ListNode<String> midPointer = slowPointer;

		// reverse 2nd half
		// You can also revisit LinkedListReversal.java
		ListNode<String> prevPointer = slowPointer;
		ListNode<String> currPointer = slowPointer.getNext();

		while (currPointer != null) {
			ListNode<String> nextPointer = currPointer.getNext();
			currPointer.setNext(prevPointer);
			prevPointer = currPointer;
			currPointer = nextPointer;
		}

		// detach first half
		midPointer.setNext(null);

		// currPointer is now null
		// prevPointer will point to the last element of original list
		// which is now 1st element of 2nd half reversed list

		ListNode<String> reveredSecondHalf = prevPointer;
		ListNode<String> firstHalf = head;
		while (reveredSecondHalf != null) {
			if (!reveredSecondHalf.getValue().equals(firstHalf.getValue())) {
				isPanindrome = false;
				break;
			}
			reveredSecondHalf = reveredSecondHalf.getNext();
			firstHalf = firstHalf.getNext();
		}

		return isPanindrome;
	}

	public static void main(String args[]) {

		System.out.println(LinkedListPalindromeFinder.isPalindrome(DSFactory.getPalindromicStringLinkedList()));
		System.out.println(LinkedListPalindromeFinder.isPalindrome(DSFactory.getStringLinkedList()));

		System.out.println(LinkedListPalindromeFinder.isPalindrome2(DSFactory.getPalindromicStringLinkedList()));
		System.out.println(LinkedListPalindromeFinder.isPalindrome2(DSFactory.getStringLinkedList()));

	}

}
