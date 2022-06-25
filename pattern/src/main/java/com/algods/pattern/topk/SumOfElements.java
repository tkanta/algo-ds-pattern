package com.algods.pattern.topk;

import java.util.PriorityQueue;

public class SumOfElements {
	
	/**
	 * Time complexity O(N*logN)
	 * Space Complexity O(N)
	 * @param nums
	 * @param k1
	 * @param k2
	 * @return
	 */
	public static int findSumOfElementsLogN(int[] nums, int k1, int k2) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2) -> n1-n2);
		
		for(int i : nums) {
			minHeap.add(i);
		}
		
		for(int j=1; j<=k1; j++) {
			minHeap.poll();
		}
		
		int sum = 0;
		
		for(int k=1; k <= k2-k1-1; k++) {
			sum += minHeap.poll();
		}
		return sum;
	}
	
	/**
	 * Time Complexity O(N*logK2)
	 * Space Complexity O(K2)
	 * @param nums
	 * @param k1
	 * @param k2
	 * @return
	 */
	public static int findSumOfElementsLogK(int[] nums, int k1, int k2) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

		for (int i =0; i< nums.length; i++) {
			if(i < k2-1)
				maxHeap.add(nums[i]);
			else if(nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}

		int sum = 0;

		for (int k = 0; k < k2 - k1 - 1; k++) {
			sum += maxHeap.poll();
		}
		return sum;
	}

	public static void main(String[] args) {
	    int result = SumOfElements.findSumOfElementsLogK(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
	    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

	    result = SumOfElements.findSumOfElementsLogK(new int[] { 3, 5, 8, 7 }, 1, 4);
	    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
	  }
}
