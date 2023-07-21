package org.dsajava.sumit;

import java.util.Scanner;

public class SequentialSearch {
	public static int SequentialSearch(int []arr, int data) {
		for(int i=0; i<arr.length;i++) {
			if(arr[i]==data) {
				return  i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] elements = {12, 15, 66, 23, 98, 44, 76, 23, 90, 35, 87,22, 34, 10, 7, 24, 67, 33, 100};
		System.out.println("The array: ");
		for(int i=0;i<elements.length;i++) {
			System.out.print(elements[i] + " ");
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the element you want to search: ");
		int value = sc.nextInt();
		int x = SequentialSearch(elements, value);
		if(x!=-1) {
			System.out.print("Element " + value + " is found at: " + x);
		}
		else {
			System.out.println("Element not found.");
		}
	}

}