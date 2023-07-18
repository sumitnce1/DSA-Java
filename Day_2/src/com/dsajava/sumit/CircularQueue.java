package com.dsajava.sumit;

public class CircularQueue<T> {
	private T[] queue;
	private int rear;	
	private int front;
	private int size;
	private int capacity;

	//Constructor
	public CircularQueue(int capacity){
		queue = (T[]) new Object[capacity];
		rear = -1;
		front = -1;
		size =0;
		this.capacity = capacity;
	}
	// is Full
	public boolean isFull() {
		return size==capacity;
	}

	// is Empty
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enqueue(T element) {
		if (isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		rear =(rear+1)% capacity;
		queue[rear]= element;
		
		if(front==-1) {
			front =rear;
		}
		size++;
	}
	
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is Empty");
		}
		T element = queue[front];
		queue[front]= null;
		if (front ==rear) {
			front =-1;
			rear =-1;
		}
		else {
			front= (front+1)%capacity;		
		}
		size--;
		return element;
	}

	//Main Method
	public static void main(String[] args) {
		CircularQueue<String> queue = new CircularQueue<>(5);
	//	queue.dequeue();
		queue.enqueue("Apple");
		queue.enqueue("Guava");
		queue.enqueue("Orange");
		queue.enqueue("Kiwi");
		System.out.println("Element popped: "+queue.dequeue());
		queue.enqueue("WaterMelon");
		queue.enqueue("Banana");
		//queue.enqueue("Grapes");
		System.out.println("Element popped: "+queue.dequeue());
		System.out.println("Element popped: "+queue.dequeue());
		
		queue.enqueue("Mango");
		queue.enqueue("Chickoo");
		
		System.out.println("Element popped: "+queue.dequeue());
		System.out.println("Element popped: "+queue.dequeue());
		System.out.println("Element popped: "+queue.dequeue());
		System.out.println("Element popped: "+queue.dequeue());
		System.out.println("Element popped: "+queue.dequeue());		
	}

}