package org.dsajava.sumit;

public class QuickSort {
	public static void qs(int[]arr) {
		if(arr==null||arr.length==0) {
			return;
		}
		quick(arr,0,arr.length -1);
	}

	private static void quick(int[] arr, int low, int high) {
		if(low<high) {
			int pivotIndex=partition(arr,low,high);
			System.out.println("Pivot: " + arr[pivotIndex]);
			System.out.print("First partition: ");
			for(int i=low;i<pivotIndex; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();

			System.out.print("Second Parition: ");
			for(int i=pivotIndex+1;i<=high;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			quick(arr, low, pivotIndex-1);
			quick(arr, pivotIndex+1,high);
		}

	}

	private static int partition(int[]arr, int low, int high) {
		int pivot = arr[high];
		int i = low -1;
		for(int j = low; j<high; j++) {
			if(arr[j]<pivot) {
				i++;
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}

	public static void display(int arr[]) {
		for(int n:arr) {
			System.out.print(n+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[]= {90,64,84,22,53,47,24,46,37,75,12,65,86,35,33,54,77,19,98};
		System.out.println("Originl Array: ");
		display(arr);
		qs(arr);
		System.out.println("Sorted Array: ");
		display(arr);
	}

}