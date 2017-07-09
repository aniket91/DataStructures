package com.osfg.factory;

import com.osfg.models.ListNode;

import java.util.Arrays;
import java.util.Random;

import com.osfg.models.BTreeNode;

/**
 * 
 * @author athakur
 * Factory class to get pre populated objects
 */
public class DSFactory {

	/**
	 * 
	 * @return Singly linked list with numeric data
	 */
	public static ListNode<Integer> getNumericLinkedList() {
		
		ListNode<Integer> head = new ListNode<>(0);
		ListNode<Integer> first = new ListNode<>(1);
		ListNode<Integer> second = new ListNode<>(2);
		ListNode<Integer> third = new ListNode<>(3);
		ListNode<Integer> fourth = new ListNode<>(4);
		head.setNext(first);
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		return head;
	}
	
	/**
	 * 
	 * @param sorted if array needs to be sorted
	 * @return array data
	 */
	public static int[] getArray(boolean sorted) {
		
		if(sorted) {
			return new int[]{2, 3, 3, 7, 9, 12, 15, 15, 15};
		}
		else {
			return new int[]{15, 9, 20, 16 ,4, 1, 7};
		}
		
	}
	
	
	/**
	 * 
	 * @return binary search tree
	 */
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
	
	/**
	 * 
	 * @return a binary tree
	 */
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
	
	/**
	 * 
	 * @param sorted if array is sorted
	 * @param arraySize size of the array to be created
	 * @param maxBound elements will be in range 0 - maxBound
	 * @return
	 */
	public static int[] getArray(boolean sorted, int arraySize, int maxBound) {
		
		Random random = new Random();
		int[] array = new int[arraySize];
		
		for(int i=0; i< arraySize;i++) {
			array[i] = random.nextInt(maxBound);
		}
		
		if(sorted) {
			Arrays.sort(array);
		}
		
		return array;
		
	}
	
	/**
	 * 
	 * @return singly linked list with palindromic string
	 */
	public static ListNode<String> getPalindromicStringLinkedList() {
		
		ListNode<String> head = new ListNode<>("a");
		ListNode<String> first = new ListNode<>("b");
		ListNode<String> second = new ListNode<>("c");
		ListNode<String> third = new ListNode<>("b");
		ListNode<String> fourth = new ListNode<>("a");
		head.setNext(first);
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		return head;
	}
	
	/**
	 * 
	 * @return singly linked list consisting of string elements
	 */
	public static ListNode<String> getStringLinkedList() {
		
		ListNode<String> head = new ListNode<>("a");
		ListNode<String> first = new ListNode<>("b");
		ListNode<String> second = new ListNode<>("c");
		ListNode<String> third = new ListNode<>("e");
		ListNode<String> fourth = new ListNode<>("f");
		head.setNext(first);
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		return head;
	}
}
