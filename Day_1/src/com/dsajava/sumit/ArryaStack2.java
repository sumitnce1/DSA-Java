package com.dsajava.sumit;

import java.util.Scanner;

public class ArryaStack2 {
	private int maxSize;
	private int[]stackArray;
	private int top;

	ArryaStack2(int size) {
		maxSize = size;
		stackArray = new int[maxSize];
		top = -1;
	}

	// is Full
	public boolean isFull() {
		return (top == maxSize - 1);
	}

	// is Empty
	public boolean isEmpty() {
		return (top == -1);
	}

	// method for taking user input in stack
	public void push() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter elements :");
		int value = sc.nextInt();
		if (isFull()) {
			System.out.println("Sorry can't insert " + value + " as stack is full.");
			return;
		}
		top++;
		stackArray[top] = value;
		System.out.println("Value " + value + " inserted at " + top);
	}

	// method for extraction in stack
	public int pop() {
		if (isEmpty()) {
			System.out.println("Sorry! Stack is empty.");
			return -1;
		}
		int poppedElement = stackArray[top];
		top--;
		return poppedElement;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty! No elements found.");
			return -1;
		}
		return stackArray[top];
	}

	public static void main(String args[]) {
		ArryaStack2 stk = new ArryaStack2(10);
		System.out.println("Top most element is " +stk.peek());
		stk.push();
		stk.push();
		stk.push();
		stk.push();
		stk.push();
		stk.push();
		stk.push();
		stk.push();
		stk.push();
		stk.push();
		System.out.println("Top most element is " +stk.peek());
		for(int x=0; x<stk.top; x++) {
			System.out.println(stk.stackArray[x]);	
		}		
	}
}