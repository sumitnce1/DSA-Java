package com.dsajava.sumit;

import java.util.Scanner;

public class QueueArray<T> {

    private Object[] queue;
    private int firstIndex;
    private int lastIndex;
    private int size;

    public QueueArray(int capacity) {
        queue = new Object[capacity];
        firstIndex = -1;
        lastIndex = -1;
        size = 0;
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

    @SuppressWarnings("unchecked")
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the queue: ");
        int queueSize = sc.nextInt();
        QueueArray<Integer> obj = new QueueArray<>(queueSize);
        for (int i = 0; i < queueSize; i++) {
            System.out.print("Enter the element: ");
            int element = sc.nextInt();
            obj.enqueueLast(element);
            System.out.println("Added: " + element);
        }
        
        System.out.println("Queue is full... Can't add more elements.");
        System.out.println();
        System.out.print("Enter the number of elements you want to remove from the queue: ");
        
        int deleteElement = sc.nextInt();
        for (int i = 0; i < deleteElement; i++) {
            int deleted = obj.dequeue();
            System.out.println("Deleted: " + deleted);
        }
    }
}
