package org.dsajava.sumit;

public class StackII {
	private Node top;
	
	private static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next= null;
		}
	}
	
	public StackII() {
		this.top =null;
	}
	public boolean isEmpty() {
		return top == null;
	}
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is Empty!");
			return -1;
		}
		return top.data;
	}	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}	
	public int pop() {
		if (isEmpty()) {
			System.err.println("Stack is Empty.");
			return -1;
		}
		int d = top.data;
		top = top.next;
		return d;
	}
	public void display() {
		Node current = top;
		System.out.println("\n Stack Node(top to bottom): ");
		while(current!=null) {
			System.out.println(current.data+" ");
			current = current.next;					
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackII stk = new StackII();
		stk.push(20);
		stk.push(25);
		System.out.println("Top element: " +stk.peek());
		stk.display();

	}

}
