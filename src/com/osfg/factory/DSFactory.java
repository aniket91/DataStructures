package com.osfg.factory;

import com.osfg.models.ListNode;

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
		head.setNext(first);
		first.setNext(second);
		second.setNext(third);
		return head;
		
	}
	
	
}
