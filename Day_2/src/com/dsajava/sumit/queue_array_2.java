package com.dsajava.sumit;

import java.util.Scanner;

public class queue_array_2<T> {
	private Object[]queue;
	private int firstIndex;
	private int lastIndex;
	private int size;

	public queue_array_2(int capacity){
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
		return size==queue.length;	
	}
	
	public void enqueueFirst() {
		if(isFull()) {
			throw new IllegalStateException("Queue is full");
	}
	if(isEmpty()) {
		firstIndex = 0;
		lastIndex = 0;
		
	}
	else {
		firstIndex = (firstIndex-1+queue.length)% queue.length;
	}
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the new Element : ");
	T element = (T)sc.next(); 
	
	
	queue[firstIndex] = element;
	System.out.println("New element added: " + element);
	size++;
	}
	
	public void enqueueLast() {
		if(isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		if(isEmpty()) {
			firstIndex = 0;
			lastIndex = 0;
		}
		else {
			lastIndex = (lastIndex+1)% queue.length;
			
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Last Element : ");
		T element = (T)sc.next(); 		
		
		queue[lastIndex]= element;
		size++;
		
	}
	
	
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		T element = (T)queue[firstIndex];
		queue[firstIndex]=null;
		
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
		queue_array_2<Integer> q1 = new queue_array_2<>(5);
		q1.enqueueFirst();
		q1.enqueueFirst();
		q1.enqueueFirst();
		q1.enqueueFirst();
		q1.enqueueFirst();
		//q1.enqueueLast();
		
		
		for(int x=0; x<q1.size; x++) {
			System.out.println("Element at the "+ x + " index is :" + q1.queue[x]);	
		}				
		System.out.println("size of queue: "+q1.size());
		System.out.println("Element popped: "+q1.dequeue());

	}
	
}