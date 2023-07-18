package com.dsajava.sumit;

public class ArrayStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public ArrayStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Sorry, can't insert " + value + " as the stack is full.");
            return;
        }
        top++;
        stackArray[top] = value;
        System.out.println("Value " + value + " inserted at index " + top);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Sorry! Can't perform pop operation as the stack is empty!");
            return -1;
        }
        int poppedElement = stackArray[top];
        top--;
        return poppedElement;
    }
    
    public int peek() {
    	if(isEmpty()) {
    		System.out.println("Stack is Empty! No elements found!");
    		return -1;
    	}
    	return stackArray[top];
    }

    public static void main(String[] args) {
        ArrayStack stk = new ArrayStack(5);
                
        stk.push(10);
        System.out.println("Top most element is: " + stk.peek());
        stk.push(20);
        stk.push(550);
        stk.push(200);
        System.out.println("Top most element is: " + stk.peek());
        
        for(int x=0; x<stk.maxSize; x++) {
        	System.out.println(stk.stackArray[x]);
        }
        System.out.println("Element remove: "+stk.pop());
        stk.push(120);
        stk.push(100);
        stk.push(67);
        stk.push(87);
        stk.push(99);
        stk.push(12);
        stk.push(37);
        stk.push(55);
        stk.push(110);
        System.out.println("Element removed: "+stk.pop());
    }
}
