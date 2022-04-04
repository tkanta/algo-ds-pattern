package com.algods.pattern.sliding;

public class SmallestSubArrayWithGreatestSum {
	
	/**
	 * Given an array of positive numbers and a positive number ‘S,’ find the length
	 * of the smallest contiguous subarray whose sum is greater than or equal to
	 * ‘S’. Return 0 if no such subarray exists. Track minimum length of window
	 * Track Sum >= S
	 * 
	 * @param arr
	 * @param S
	 * @return
	 */
	private static int findMinSubArray(int[] arr, int S) {
		int windowSum = 0, windowStart = 0, minWinLength = Integer.MAX_VALUE;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			
			// shrink the window as small as possible until the 'windowSum' is smaller than 'S'
			while(windowSum >= S) {
				minWinLength = Math.min(minWinLength, windowEnd-windowStart+1);
				windowSum -= arr[windowStart];
				windowStart++;
				
//				do {
//					windowSum -= arr[windowStart];
//					lengthCount--;
//					if(lengthCount <= 0) {
//						minWinLength = 1;
//					}
//					windowStart++;
//				}while(windowSum >= S);
				
			}
		}
		return minWinLength == Integer.MAX_VALUE ? 0 : minWinLength;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 5, 2, 8};
		int len = findMinSubArray(arr, 7);
		System.out.println(len);
	}
	
	
	// The time complexity of the above algorithm will be O(N). The outer for loop runs for all elements, and the inner while loop processes each element only once; therefore, the time complexity of the algorithm will be O(N+N)O(N+N), which is asymptotically equivalent to O(N)O(N).
	// The algorithm runs in constant space O(1).
}
