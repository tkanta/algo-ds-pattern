package com.algods.pattern.topk;

import java.util.PriorityQueue;

/**
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
