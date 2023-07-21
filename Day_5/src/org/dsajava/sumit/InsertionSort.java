package org.dsajava.sumit;

public class InsertionSort {

	public static void insertionSort(int[]arr) {
		int n = arr.length;

		for(int i=0;i<arr.length;i++) {
			int key = arr[i];
			int j = i-1;

			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;

			System.out.println("\n");
			for(int k=0;k<arr.length;k++) {
				System.out.print(" " + arr[k]);
			}
		}
	}
	public static void main(String[] args) {
		int elements[]= {34,7,23,98,11,56,88,99,4,76,63,92};
		System.out.print("Original Array : ");
		for(int i=0;i<elements.length;i++) {
			System.out.print(" " + elements[i]);
		}
		System.out.println("\n");
		insertionSort(elements);
		System.out.println("\n");
		System.out.print("\n\nSorted Array : ");
		for(int i=0;i<elements.length;i++) {
			System.out.print(" " + elements[i]);
		}
	}
}		