package com.algods.heap;

import java.util.Arrays;

public class FindKSmallestElements {
	
	public static int[] findSmallest(int[] arr, int k) {
		int[] result = new int[k];
		int smallestIndex = 0;
		int index = 0;
		result[index++] = arr[smallestIndex];
		while(index < k ) {
			int left = 2 * smallestIndex + 1 ;
			int right = 2 * smallestIndex + 2;
			
			if(arr[left] < arr[right]) {
				smallestIndex = left;
			}else {
				smallestIndex = right;
			}
			result[index++] = arr[smallestIndex];
		}
		
		return result;
	}
	
	
	private static void buildMinHeap(int[] heapArray, int heapSize) {

		// swap smallest child to parent node
		for (int i = (heapSize - 1) / 2; i >= 0; i--) {
			minHeapify(heapArray, i, heapSize);
		}
	}

	private static void minHeapify(int[] heapArray, int index, int heapSize) {
		int smallestIndex = index;

		while (smallestIndex < heapSize / 2) { // check parent nodes only
			int left = (2 * index) + 1; // left child
			int right = (2 * index) + 2; // right child
			if (left < heapSize && heapArray[left] < heapArray[index]) {
				smallestIndex = left;
			}

			if (right < heapSize && heapArray[right] < heapArray[smallestIndex]) {
				smallestIndex = right;
			}

			if (smallestIndex != index) { // swap parent with smallest child
				int temp = heapArray[index];
				heapArray[index] = heapArray[smallestIndex];
				heapArray[smallestIndex] = temp;
				index = smallestIndex;
			} else {
				break; // if heap property is satisfied
			}
		} // end of while
	}
	
	public static void main(String[] args) {
		int[] arr = {9,4,7,1,-2,6,5};
		
		FindKSmallestElements se = new FindKSmallestElements();
		
		se.buildMinHeap(arr, arr.length);
		
		int[] res = se.findSmallest(arr, 4);
		
		System.out.println("result : "+Arrays.toString(res));
	}
}
