package com.algods.pattern.topk;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 * Find Top 'K' Frequent Numbers
 * Time Complexity O(N+N∗logK)
 * @author tarin
 *
 */
public class TopKFrequentNumbers {
	
	
	/**
	 * Educative (Better performance)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
		// find the frequency of each number
		Map<Integer, Integer> numFrequencyMap = new HashMap<>();
		for (int n : nums)
			numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
		
		//Same value priority will be given to repetition of that number
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(
				(e1, e2) -> e1.getValue() - e2.getValue());

		// go through all numbers of the numFrequencyMap and push them in the minHeap,
		// which will have
		// top k frequent numbers. If the heap size is more than k, we remove the
		// smallest (top) number
		for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
			minHeap.add(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		// create a list of top k numbers
		List<Integer> topNumbers = new ArrayList<>(k);
		while (!minHeap.isEmpty()) {
			topNumbers.add(minHeap.poll().getKey());
		}
		return topNumbers;
	}
	
	
	
	/**
	 * Educative test
	 */
	public static void eduTest() {
		List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11, 12 }, 2);
	    System.out.println("Here are the K frequent numbers: " + result);

	    result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5,5,5, 12, 11, 3, 11, 14, 14, 14 }, 2);
	    System.out.println("Here are the K frequent numbers: " + result);
	}
	
	
	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {
		Instant start = Instant.now();
		eduTest();
		Instant end = Instant.now();
		System.out.println("Time taken in mili second : "+Duration.between(start, end).toMillis());
	}
	
	
	//=================================
	/**
	 * Self
	 * @param nums
	 * @param k
	 * @return
	 */
//	public static List<Integer> findTopKFrequentNumbers_self(int[] nums, int k){
//		
//		PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2) -> n1 - n2);
//		Set<Integer> frequentNo = new HashSet<>();
//		
//		for(int i=0; i<k; i++) {
//			minHeap.add(nums[i]);
//		}
//		
//		for(int j=k; j<nums.length; j++) {
//			int top = minHeap.peek();
//			if(nums[j] > top && !minHeap.contains(nums[j])) {
//				minHeap.poll();
//				minHeap.add(nums[j]);
//			}else if(minHeap.contains(nums[j])) {
//				frequentNo.add(nums[j]);
//			}
//		}
//		
//		minHeap.retainAll(frequentNo);
//		return new ArrayList<>(minHeap);
//	}
	/**
	 * Self Test
	 */
//	public static void selfTest() {
//		List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers_self(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
//	    System.out.println("Here are the K frequent numbers: " + result);
//
//	    result = TopKFrequentNumbers.findTopKFrequentNumbers_self(new int[] { 5, 12, 11, 3, 11, 13, 13 }, 2);
//	    System.out.println("Here are the K frequent numbers: " + result);
//	}	
}
