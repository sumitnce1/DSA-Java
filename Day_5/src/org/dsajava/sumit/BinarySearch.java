package org.dsajava.sumit;

import java.util.Scanner;

import java.util.Scanner;

public class BinarySearch {

	public static int bs(int arr[], int data) {
		int left =0;
		int right = arr.length -1;
		
		while(left<=right) {
			int mid=(left+right)/2;
			
			System.out.println("Left: " +left+", Right: " + right + ", Mid: " + mid);
			if(arr[mid]==data) {
				return mid;
			}
			else if(arr[mid]<data) {
				System.out.println(arr[mid]+" is smaller than " + data);
				left = mid+1;
			}
			else {
				System.out.println(arr[mid]+" is greater than " + data);
				right = mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {

		int elements[] = {1,7,10,14,18,22,24,28,31,34,37,40,46,51,55,60,63,67,71,82,88,90};
		
		System.out.println("The array: ");
		for(int i=0;i<elements.length;i++) {
			System.out.print(elements[i] + " ");
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the element you want to search: ");
		int value = sc.nextInt();
		int result = bs(elements,value);
		
		if(result==-1) {
			System.out.println("Element is not found!");
		}
		else {
			System.out.println("Element "+value+" is found at " + result);
		}
	}

}