package com.dsajava.sumit;

public class QueueArray {
    private Object[] queue;
    private int firstIndex;
    private int lastIndex;
    private int size;    
    
    public QueueArray (int capacity) {
    	queue = new Object[capacity];
    	firstIndex = -1;
    	lastIndex = -1;
    	size = 0;    	
    }
    
    private int size() {
    	return size;    	
    }
    private boolean isEmpty() {
    	return size==0;
    }
    private boolean isFull() {
    	return size== queue.length;
    }
}
