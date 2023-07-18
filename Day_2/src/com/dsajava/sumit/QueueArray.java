package com.dsajava.sumit;

import java.nio.channels.IllegalSelectorException;

public class QueueArray<T> {
	private Object[] queue;
	private int firstIndex;
	private int lastIndex;
	private int size;    

	public QueueArray (int capacity) {
		queue = new Object[capacity];
		firstIndex = -1;
		lastIndex = -1;
		size = 0;    	
	}

	private int size() {
		return size;    	
	}
	private boolean isEmpty() {
		return size==0;
	}
	private boolean isFull() {
		return size== queue.length;
	}
	public void enqueueFirst(T element) {
		if(isFull()) {
			throw new IllegalStateException("Queue is Full.");
		}
		if(isEmpty()) {
			firstIndex = 0;
			lastIndex = 0;
		}
		else {
			firstIndex = (firstIndex-1 + queue.length) % queue.length;
		}
		queue[firstIndex] = element;
		size++;
	}

	public void enqueueLast(T element) {
		if (isFull()) {
			throw new IllegalStateException("Queue is Full");			
		}
		if (isEmpty()) {
			firstIndex= 0;
			lastIndex = 0;
		}
		else {
			lastIndex = (lastIndex+1)% queue.length;
		}
		queue[lastIndex] = element;
		size++;
	}

}