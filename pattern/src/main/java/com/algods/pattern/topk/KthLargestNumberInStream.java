package com.algods.pattern.topk;

import java.util.PriorityQueue;

/**
 * Design a class to efficiently find the Kth largest element in a stream of numbers.

The class should have the following two things:

The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
The class should expose a function add(int num) which will store the given number and return the Kth largest number.
 * O(logK)
 * @author tarin
 *
 */
public class KthLargestNumberInStream {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2) -> n1-n2);
	final int k;
	
	public KthLargestNumberInStream(int num[], int k) {
		this.k = k;
		for(int i=0; i<num.length; i++) {
			add(num[i]);
		}
	}
	
	public int add(int num) {
		
		minHeap.add(num);
		
		if(minHeap.size() > this.k) {
			minHeap.poll();
		}
		
		return minHeap.peek();
	}
	
	public static void main(String[] args) {
		int[] input = {3,1,5,12,2,11};
		KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
		System.out.println("4th largest number is: " + kthLargestNumber.add(6));
	    System.out.println("4th largest number is: " + kthLargestNumber.add(13));
	    System.out.println("4th largest number is: " + kthLargestNumber.add(4));
		
	}
}
