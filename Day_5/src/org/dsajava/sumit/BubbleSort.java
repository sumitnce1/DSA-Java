package org.dsajava.sumit;

public class BubbleSort {
	public static void bubble(int[]arr) {
		boolean swapped;
		
		for(int i=0; i<arr.length;i++) {
			swapped = false;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
			System.out.print("\nAfter " + i + " pass: ");
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
		System.out.println();
		bubble(elements);
		System.out.print("\n\nSorted Array : ");
		for(int i=0;i<elements.length;i++) {
			System.out.print(" " + elements[i]);
		}

	}
}