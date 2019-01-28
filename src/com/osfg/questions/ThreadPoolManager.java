package com.osfg.questions;

import com.osfg.models.BlockingQueue;

/**
 * 
 * @author athakur
 * Simple thread pool implementation in Java using BlockingQueue
 */
public class ThreadPoolManager {
	
	//assuming size of queue to be 10
	private final BlockingQueue<Runnable> threadPoolQueue = new BlockingQueue<Runnable>(10);;
	private final int MAX_THREAD_POOL_SIZE;
	
	public ThreadPoolManager(int maxThreadPoolSize) {
		MAX_THREAD_POOL_SIZE = maxThreadPoolSize;
		initThreads();
	}
	
	
	private void initThreads() {
		for(int i=0; i< MAX_THREAD_POOL_SIZE;i++) {
			final int threadNo = i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						try {
							threadPoolQueue.dequeue().run();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
	
	public void enqueueTask(Runnable runnable) throws InterruptedException {
		threadPoolQueue.enqueue(runnable);
	}
	
	public static void main(String args[]) throws InterruptedException {
		
		ThreadPoolManager tmManager = new ThreadPoolManager(10);
		tmManager.enqueueTask(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Sumitting task A");
				System.out.println("Completing task A");
				
			}
		});
		tmManager.enqueueTask(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Sumitting task B");
				System.out.println("Completing task B");
				
			}
		});
		
		
	}

}

