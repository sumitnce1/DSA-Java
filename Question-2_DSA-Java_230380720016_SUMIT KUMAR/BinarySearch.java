package com.dsajava.sumit0016;
import java.util.Scanner;
//Q.2 Write a program to implement Binary search on an array of 15 elements.
public class BinarySearch {
	public static int bs(int arr[], int data) {
		int left =0;
		int right = arr.length -1;

		while(left<=right) {
			int mid=(left+right)/2;
			System.out.println();
			System.out.println("On Left: " +left+", On Right: " + right + ", In Mid: " + mid);
			if(arr[mid]==data) {
				return mid;
			}
			else if(arr[mid]<data) {
				System.out.println(arr[mid]+" is smaller than: " + data);
				left = mid+1;
			}
			else {
				System.out.println(arr[mid]+" is greater than: " + data);
				right = mid-1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int elements[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

		System.out.print("The array: ");
		for(int i=0;i<elements.length;i++) {
			System.out.print(elements[i] + " ");
		}
		Scanner bn = new Scanner(System.in);
		System.out.print("\nEnter the Element to Search: ");
		int value = bn.nextInt();
		int result = bs(elements,value);

		if(result==-1) {
			System.out.println("Element Not Found!");
		}
		else {
			System.out.println();
			System.out.println("The Element "+value+" Found At Index: " + result+".");
		}
	}
}