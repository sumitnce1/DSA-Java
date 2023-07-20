package org.dsajava.sumit;

import java.util.Scanner;

public class AlmostCompleteBinaryTree {
	private int [] treeArray;
	private int size;
	private int capacity;

	public AlmostCompleteBinaryTree(int capacity) {
		this.treeArray = new int[capacity];
		this.size = 0;
		this.capacity =capacity;
	}	
	public boolean isFull() {
		return size == capacity;
	}
	public void insert(int data) {
		if (isFull()) {
			System.out.println("Tree is Full, Cannot insert more elements.");
			return;
		}
		treeArray[size] = data;
		size++;
	}
	
	public void printLevelOrder() {
		System.out.println("Level order printing: ");
		for(int i=0; i<size; i++ ) {
			System.out.println(" "+treeArray[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		System.out.println("Please enter the capcity: ");
		Scanner sc = new Scanner(System.in);
		int capacity = sc.nextInt();
		
		AlmostCompleteBinaryTree acbt = new AlmostCompleteBinaryTree(capacity);
		System.out.println("Enter " +capacity+ " elements for the tree..");
		for(int i =0; i<capacity; i++) {
			int value = sc.nextInt();
			acbt.insert(value);
		}
		acbt.printLevelOrder();
		sc.close();
	}

}
