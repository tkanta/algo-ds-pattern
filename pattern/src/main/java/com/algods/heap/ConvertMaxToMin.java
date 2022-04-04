package com.algods.heap;

import java.util.Arrays;

public class ConvertMaxToMin {
	public static void convertMaxToMinHeap(int[] maxHeap) {

		// Consider maxHeap just an ordinary unsorted array
		// Build minHeap of the given array. (We already covered that in previous
		// lesson)
		// Return converted array in String format
		buildMinHeap(maxHeap, maxHeap.length);

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

	public static void main(String args[]) {
		int[] heapArray = { 9, 4, 7, 1, -2, 6, 5 };
		//int[] heapArray = { 6, 34, 7, 11, 2, 9, 3 , 1 };
		System.out.println("Max Heap: " + Arrays.toString(heapArray));
		convertMaxToMinHeap(heapArray);
		System.out.println("Min Heap: " + Arrays.toString(heapArray));

	}
}
