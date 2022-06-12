package com.algods.pattern.topk;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class TopKNumbers {

	//==================== self solution ======================
	public static List<Integer> findKLargestNumbers_self(Integer[] nums, int k){
		
		Arrays.sort(nums, Comparator.reverseOrder());;
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<k; i++) {
			res.add(nums[i]);
		}
		return res;
	}
	
	
	
	//======================== Educative =====================
	
	public static List<Integer> findKLargestNumbers_with_maxheap(Integer[] nums, int k){
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2) -> n2-n1); // Decending order
		List<Integer> list = new ArrayList<>();
		
		//add first k numbers to minHeap
		for(int i=0; i<nums.length; i++) {
			maxHeap.add(nums[i]);
		}
		
		//iterate rest of elements and add to minheap, insert large number and fish out the small number.
		// At last only k large number exist
		for(int i=0; i<k; i++) {
			list.add(maxHeap.poll());
		}
		
		
		return list;
}
	
	public static List<Integer> findKLargestNumbers_with_minheap(Integer[] nums, int k){
			PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2) -> n1-n2); // Ascending order
			
			//add first k numbers to minHeap
			for(int i=0; i<k; i++) {
				minHeap.add(nums[i]);
			}
			
			//iterate rest of elements and add to minheap, insert large number and fish out the small number.
			// At last only k large number exist
			for(int i=k; i<nums.length; i++) {
				if(nums[i]> minHeap.peek()) {
					minHeap.poll();
					minHeap.add(nums[i]);
				}
			}
			
			// shortcuts for above code		
//			for(int i: nums) {
//				minHeap.add(i);
//				if(minHeap.size() > k) {
//					minHeap.poll();
//				}
//			}
			
			
			return new ArrayList<>(minHeap);
	}
	
	public static void main(String[] args) {
		
		List<Integer> res = TopKNumbers.findKLargestNumbers_with_minheap(new Integer[] {3, 1, 5, 12, 2, 11, 6, 6}, 3);
		System.out.println("Top K numbers : "+ res);
		
		//------------ test performance of self ----------------------- 
//		Instant start = Instant.now();
//		IntStream.range(1, 100).forEach(n -> {
//			TopKNumbers.findKLargestNumbers_self(new Integer[] {3, 1, 5, 12, 2, 11}, 3);
//		});
//		Instant stop = Instant.now();
//		System.out.println("Array sort performance for Top K elements : "+Duration.between(start, stop).toMillis());
		
		// -------------- test performance of educative -----------------
//		start = Instant.now();
//		IntStream.range(1, 100).forEach(n -> {
//			TopKNumbers.findKLargestNumbers_with_minheap(new Integer[] {3, 1, 5, 12, 2, 11}, 3);
//		});
//		stop = Instant.now();
//		System.out.println("Heap performance for Top K elements : "+ Duration.between(start, stop).toMillis());
		
	}
}
