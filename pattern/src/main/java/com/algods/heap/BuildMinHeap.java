package com.algods.heap;

import java.util.Arrays;

public class BuildMinHeap {

	private void minHeapify(int[] heapArr, int index, int heapSize) {
		
		int smallestIndex = index;
		
		/**
		 * if smallestIndex is one of the nodes, and had a swap, we need to iterate once more to check if it is smallest than your 
		 * children's. if the smallestIndex is not among the nodes than we don't need iteration.
		 */
		while(smallestIndex <= heapSize/2) {
			int left = 2 * index + 1 ;
			int right = 2 * index + 2;
			
			if(left < heapSize && heapArr[left] < heapArr[index]) {
				smallestIndex = left;
			}
			if(right < heapSize && heapArr[right] < heapArr[smallestIndex]) {
				smallestIndex = right;
			}
			
			if(smallestIndex != index) {
				int temp = heapArr[index];
				heapArr[index] = heapArr[smallestIndex];
				heapArr[smallestIndex] = temp;
				index = smallestIndex;
			}else {
				break;
			}
		}
		
	}
	
	public void buildMinHeap(int[] heapArr, int heapSize) {
		
		//start from the last node at the last level
		for(int i = (heapSize-1)/2 ; i >= 0; i-- ) {
			minHeapify(heapArr, i, heapSize);
		}
	}
	
	public static void main(String[] args) {
		int[] heapArr = {31, 11, 7, 12, 15, 14, 9, 2, 3, 16};
		
		System.out.println("Before Heapify : "+ Arrays.toString(heapArr));
		new BuildMinHeap().buildMinHeap(heapArr,heapArr.length);
		System.out.println("After Heapify : "+ Arrays.toString(heapArr));
	}
}
