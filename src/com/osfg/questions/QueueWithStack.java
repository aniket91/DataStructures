package com.osfg.questions;

import java.util.Stack;

/**
 * 
 * @author athakur
 * Question : Use stack (LIFO) to simulate queue (FIFO)
 */
public class QueueWithStack {

	private Stack<Integer> originalStack = new Stack<>();
	private Stack<Integer> reverseStack = new Stack<>();
	
	public void enQueue(int data) {
		originalStack.push(data);
	}
	
	public int deQueue() {
		
		// reverse stack to simulate Queue - FIFO
		// Do this only when reverseStack is empty
		if(reverseStack.isEmpty()) {
			while(!originalStack.isEmpty()) {
				reverseStack.push(originalStack.pop());
			}
		}
		
		if(reverseStack.isEmpty()) {
			throw new RuntimeException("No data enqueued");
		}
		
		
		return reverseStack.pop();
	}
	
	public static void main(String args[]) {
		
		QueueWithStack queue = new QueueWithStack();
		queue.enQueue(4);
		queue.enQueue(10);
		queue.enQueue(2);
		queue.enQueue(5);
		System.out.println(queue.deQueue());
		queue.enQueue(1);
		queue.enQueue(6);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		
		
	}
	
}
