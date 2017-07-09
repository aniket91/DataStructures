package com.osfg.models;

/**
 * 
 * @author athakur
 * Model class for Linked List Node
 */
public class ListNode<E> {
	
	private E value;
	private ListNode next;
	
	public ListNode(E value) {
		this.value = value;
	}
	
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}

	public String toString() {
		ListNode currNode = this;
		String ll = String.valueOf(currNode.getValue());
		while(currNode.next != null) {
			ll = ll + " --> " + String.valueOf(currNode.getNext().getValue());
			currNode = currNode.getNext();
		}
		return ll;
	}
	
	
	

}
