package com.algods.pattern.topk;

import java.util.LinkedList;
import java.util.List;

class Entry {
	int key;
	int value;

	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class KClosestElements {

	/**
	 * Method 1 using Heap
	 * @param arr
	 * @param K
	 * @param X
	 * @return
	 */
//	public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
//	    int index = binarySearch(arr, X);
//	    int low = index - K, high = index + K;
//	    low = Math.max(low, 0); // 'low' should not be less than zero
//	    high = Math.min(high, arr.length - 1); // 'high' should not be greater the size of the array
//
//	    PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);
//	    // add all candidate elements to the min heap, sorted by their absolute difference from 'X'
//	    for (int i = low; i <= high; i++)
//	      minHeap.add(new Entry(Math.abs(arr[i] - X), i));
//
//	    // we need the top 'K' elements having smallest difference from 'X'
//	    List<Integer> result = new ArrayList<>();
//	    for (int i = 0; i < K; i++)
//	      result.add(arr[minHeap.poll().value]);
//
//	    Collections.sort(result);
//	    return result;
//	  }
	
	/**
	 * Method 2 
	 * @param arr
	 * @param K
	 * @param X
	 * @return
	 */
	public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
		List<Integer> list = new LinkedList<>();
		int index = binarySearch(arr, X);
		
		int leftPointer = index;
		int rightPointer = index+1;
		
		for(int i=0; i<K; i++) {
			
			if(leftPointer >= 0 && rightPointer < arr.length) {
				int diff1 = Math.abs(arr[leftPointer]-X);
				int diff2 = Math.abs(arr[rightPointer]-X);
				if(diff1 < diff2) {
					list.add(0,arr[leftPointer--]);
				}else {
					list.add(arr[rightPointer++]);
				}
			}else if(leftPointer >= 0) {
				list.add(0,arr[leftPointer--]);
			}else if(rightPointer < arr.length) {
				list.add(arr[rightPointer++]);
			}
		}
		
		return list;
	}
	
	private static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;
			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (low > 0) {
			return low - 1;
		}
		return low;
	}
	
	
	public static void main(String[] args) {
		List<Integer> result = null;
		
//	    result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
//	    System.out.println("'K' closest numbers to 'X' are: " + result);

//	    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
//	    System.out.println("'K' closest numbers to 'X' are: " + result);

	    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 1, 8);
	    System.out.println("'K' closest numbers to 'X' are: " + result);
	  }
}
