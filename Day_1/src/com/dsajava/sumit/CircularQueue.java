package com.dsajava.sumit;

public class CircularQueue<T> {
	private T[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;
	public CircularQueue(int capacity) {
		this.capacity = capacity;
		queue = (T[]) new Object[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	public void enqueue(T element) {
		if (isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		rear = (rear + 1) % capacity;
		queue[rear] = element;
		if (front == -1) {
			front = rear;
		}
		size++;
	}
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		T element = queue[front];
		queue[front] = null;
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % capacity;
		}
		size--;
		return element;
	}
	public boolean isFull() {
		return size == capacity;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	public static void main(String[] args) {
		CircularQueue<Integer> queue = new CircularQueue<>(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.dequeue();
		queue.enqueue(40);
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
}
