package org.dsajava.sumit;

public class SelectionSort {
	public static void selection(int[]arr) {
		if(arr==null||arr.length==0) {
			return;
		}

		for(int i=0;i<=arr.length-1;i++) {
			int minIndex =i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex]=arr[i];
			arr[i]=temp;

			System.out.print(i+"th pass: ");
			for(int z=0; z<=arr.length-1;z++) {
				System.out.print(arr[z]+" ");
			}
			System.out.println();
		}
	}
	public static void display(int[]arr) {
		for(int n:arr) {
			System.out.print(n+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[]arr= {90,64,84,22,53,47,24,46,37,75,12,65,86,35,33,54,77,19,98};
		System.out.print("Original Array: ");
		display(arr);

		selection(arr);
		System.out.print("Sorted Array: ");
		display(arr);
	}

}