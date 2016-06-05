package com.osfg.models;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author athakur
 * Model class for blocking queue
 */
public class BlockingQueue<E> {
	
	private Queue<E> bQueue = new LinkedList<E>();
	private int maxQueueSize; 
	
	public BlockingQueue(int maxQueueSize) {
		this.maxQueueSize = maxQueueSize; 
	}
	
	public synchronized void enqueue(E e) throws InterruptedException {
		
		while(bQueue.size() == maxQueueSize) {
			wait();
		}
		bQueue.add(e);
		// notify if any thread is waiting to dequeue as data is now available
		notifyAll();
    }
	
    public synchronized E dequeue() throws InterruptedException{
    	
    	while(bQueue.size() == 0) {
    		wait();
    	}
    	E e = bQueue.remove();
    	notifyAll();
    	return e;
    	
    }

}
