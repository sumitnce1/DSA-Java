package com.dsajava.sumit;

public class SinglyLinkedList {
	private Node Head;
	private static class Node{
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}	
	public void insert(int data) {
		Node newNode = new Node(data);
		if(Head == null) {
			Head = newNode;
		}
		else {
			Node current = Head;
			while(current.next !=null) {
				current = current.next;
			}
			current.next = newNode;
		}
		System.out.println("Node inserted: "+newNode.data);
	}
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next = Head;
		Head = newNode;
	}
	public void insertAtSpecific(int data, int position) {
		if (position<=0) {
			insertAtBeginning(data);
		}
		else {
			Node newNode =new Node(data);
			Node current = Head;
			int count = 0;
			Node prev = null;
			while(current!=null && count<position) {
				prev = current;
				current = current.next;
				count++;				
			}
			prev.next = newNode;
			newNode.next = current;
		}
			
	}
	public void deletionAtBeginning() {
		if (Head!= null) {
			Head = Head.next;
		}
		else {
			System.out.println("LinkedList is empty! No node to be deleted");
		}
	}
	public void deletionAtEnd() {
		if (Head == null) {
			System.out.println("LinkedList is empty! No node to be deleted.");			
		}
		else if (Head.next ==null) {
			Head = null;
		}
		else {
			Node current = Head;
			Node prev = null;
			
			while(current.next!= null) {  // lastNode = 4th
				prev =current;            // prev = current = Head = 0th Node
				current = current.next;   // current = current.next= 1st Node
			}
			prev.next =null;
		}
	}
	public void deletionAtSpecific(int position) {
		if(Head == null) {
			System.out.println("LinkedinList is empty! No node to be deleted.");
		}
		else if(position<=0) {
			deletionAtBeginning();
		}
		else {
			System.err.println("Postion out of range");
		}
	}
	public void display() {
		Node current = Head;
		System.out.println("\nNodes");
		while(current!=null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	public static void main(String[] args) {
		SinglyLinkedList ll= new SinglyLinkedList();
		ll.display();
		ll.insert(15);
		ll.insert(44);
		ll.insert(77);
		ll.insert(22);
		ll.insert(66);
		ll.insert(99);
		ll.insertAtBeginning(100);
		ll.insertAtSpecific(1, 3);
		ll.insertAtBeginning(25);
		ll.display();
		ll.deletionAtEnd();
		ll.display();
		ll.deletionAtBeginning();
		ll.display();
		ll.deletionAtSpecific(4);
		ll.display();
		ll.deletionAtEnd();
		ll.deletionAtEnd();
		ll.deletionAtEnd();
		ll.deletionAtEnd();
		ll.deletionAtEnd();
	}
}
