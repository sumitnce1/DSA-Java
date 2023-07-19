package org.dsajava.sumit;

public class queueII {
	private Node front;
	private Node rear;
	public static class Node{
		int data;
		Node next;
		
		public Node (int data) {
			this.data = data;
			next = null;
		}
	}
	public queueII() {
		this.front = null;
		this.rear = null;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty! Cannot peak...");
			return -1;
		}
		return front.data;
	}
	
	public void enqueue(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
		}else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	public int dequeue() {		
		if(isEmpty()) {
			System.out.println("Queue is Empty! cannot peek...");
			return -1;
		}
		int data = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		return data;
	}
	
	public void display() {
		Node current = front;
		System.out.println("Queue Nodes (front to rear): ");
		while(current!=null) {
			System.out.println(current.data+ " ");
			current = current.next;
		}
		System.err.println();
	}
	public static void main(String[] args) {
		queueII queue = new queueII();
		queue.enqueue(100);
		queue.enqueue(30);
		queue.enqueue(10);
		System.out.println("Element at front : "+ queue.peek());
		queue.display();
		System.out.println("Element at front : "+ queue.dequeue());
		System.out.println("Front: "+queue.front.data+ "\tRear: "+ queue.rear.data);
		

	}

}