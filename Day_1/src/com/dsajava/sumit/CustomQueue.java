package com.dsajava.sumit;

public class CustomQueue<T> {
	private Object[] queue;
	private int firstIndex;
	private int lastIndex;
	private int size;
	public CustomQueue(int capacity) {
		queue = new Object[capacity];
		firstIndex = -1;
		lastIndex = -1;
		size = 0;
	}
	public void enqueueFirst(T element) {
		if (isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		if (isEmpty()) {
			firstIndex = 0;
			lastIndex = 0;
		} else {
			firstIndex = (firstIndex - 1 + queue.length) % queue.length;
		}
		queue[firstIndex] = element;
		size++;
	}
	public void enqueueLast(T element) {
		if (isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		if (isEmpty()) {
			firstIndex = 0;
			lastIndex = 0;
		} else {
			lastIndex = (lastIndex + 1) % queue.length;
		}
		queue[lastIndex] = element;
		size++;
	}
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		T element = (T) queue[firstIndex];
		queue[firstIndex] = null;
		if (firstIndex == lastIndex) {
			firstIndex = -1;
			lastIndex = -1;
		} else {
			firstIndex = (firstIndex + 1) % queue.length;
		}
		size--;
		return element;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean isFull() {
		return size == queue.length;
	}
	public static void main(String[] args) {
		CustomQueue<Integer> queue = new CustomQueue<>(5);
		queue.enqueueLast(10);
		queue.enqueueFirst(5);
		queue.enqueueLast(20);
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
}

