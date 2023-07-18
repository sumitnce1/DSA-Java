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
	public void display() {
		Node current = Head;
		while(current!=null) {
			System.out.println(current.data+"\n");
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
		ll.display();
	}
}
