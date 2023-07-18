package com.dsajava.sumit;

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
		System.out.println("New Element Added at First: " +element);
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
		System.out.println("New Element Added at Last: " +element);
		size++;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is Empty.");
		}
		T element = (T)queue[firstIndex];
		queue[firstIndex]= null;
		
		if(firstIndex == lastIndex) {
			firstIndex = -1;
			lastIndex = -1;
		}
		else {
			firstIndex = (firstIndex+1)%queue.length;
		}
		size--;
		return element;
	}
	
	public static void main(String[] args) {
		QueueArray<Integer> q1 = new QueueArray<>(10);
		q1.enqueueFirst(10);
		q1.enqueueFirst(20);
		q1.enqueueLast(100);
		q1.size();
		System.out.println("Size of Queue: " +q1.size());
		System.out.println("Element popped: " +q1.dequeue());
		System.out.println("Element popped: " +q1.dequeue());
		System.out.println("Element popped: " +q1.dequeue());
		//System.out.println("Element popped: " +q1.dequeue());  //Exception in thread "main"
	}

}