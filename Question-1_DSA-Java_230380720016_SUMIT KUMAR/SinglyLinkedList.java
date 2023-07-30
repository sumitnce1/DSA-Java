package com.dsajava.sumit0016;
//Q.1 Write a program to perform insertion at specific index and delete at specific index of linked list.
public class SinglyLinkedList {
	private Node Head;

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (Head == null) {
			Head = newNode;
		} else {
			Node current = Head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		System.out.println("Node inserted: " + newNode.data);
	}

	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next = Head;
		Head = newNode;
	}

	public void insertAtSpecific(int data, int position) {
		if (position <= 0) {
			insertAtBeginning(data);
		} else {
			Node newNode = new Node(data);
			Node current = Head;
			int count = 1;
			Node prev = null;
			while (current != null && count < position) {
				prev = current;
				current = current.next;
				count++;
			}
			if (current == null) {
				System.out.println("Position out of range. Inserting at the end.");
			}
			prev.next = newNode;
			newNode.next = current;
			System.out.println("\nNode Inserted at Position " + position + ": " + newNode.data);
		}
	}

	public void deletionAtBeginning() {
		if (Head != null) {
			Head = Head.next;
		} else {
			System.out.println("LinkedList is empty! No node to be deleted");
		}
	}

	public void deletionAtSpecific(int position) {
		if (Head == null) {
			System.out.println("LinkedList is empty! No node to be deleted.");
		} else if (position <= 0) {
			deletionAtBeginning();
		} else {
			Node current = Head;
			int count = 1;
			Node prev = null;
			while (current != null && count < position) {
				prev = current;
				current = current.next;
				count++;
			}
			if (current == null) {
				System.out.println("Position out of range.");
				return;
			}
			prev.next = current.next;
			System.out.println("\n\nNode Deleted at Position " + position + ": " + current.data);
		}
	}

	public void display(String message) {
		Node current = Head;
		System.out.println("\n" + message);
		while (current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.display("Initial Nodes:");
		sll.insert(20);
		sll.insert(35);
		sll.insert(66);
		sll.insert(40);
		sll.insert(80);
		sll.insert(95);
		sll.insertAtBeginning(100);
		sll.insertAtSpecific(1, 3);
		sll.insertAtBeginning(30);
		sll.display("Nodes After Insertions:");        
		sll.deletionAtSpecific(5);
		sll.display("Nodes After deletionAtSpecific: ");
	}
}
