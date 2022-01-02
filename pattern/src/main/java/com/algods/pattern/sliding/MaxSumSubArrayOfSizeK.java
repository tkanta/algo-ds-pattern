package com.algods.pattern.sliding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSumSubArrayOfSizeK {

	private static Map<String, Object> findArrAndItsMaxSum(int[] arr, int k) {
		Map<String, Object> map = new HashMap<String, Object>();
		int[] result = new  int[k];
		int maxSum = 0, sum = 0, startIndex = 0, maxSumIndex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(i >= k-1) {
				if(maxSum < sum) {
					maxSum = sum;
					maxSumIndex = i;
				}
				sum -= arr[startIndex];
				startIndex++;
			}
		}
		
		for(int j=0; j<k; j++) {
			result[j] = arr[maxSumIndex-k+1+j];
		}
		
		map.put("Array", Arrays.toString(result));
		map.put("Sum", maxSum);
		return map;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {2, 3, 4, 1, 5};
		Map<String, Object> result = findArrAndItsMaxSum(arr, 3);
		System.out.println(result);
		
	}
	
//------------------- Solution --------------------
//	public static int findMaxSumSubArray(int k, int[] arr) {
//		int windowSum = 0, maxSum = 0;
//		int windowStart = 0;
//		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
//			windowSum += arr[windowEnd]; // add the next element
//			// slide the window, we don't need to slide if we've not hit the required window
//			// size of 'k'
//			if (windowEnd >= k - 1) {
//				maxSum = Math.max(maxSum, windowSum);
//				windowSum -= arr[windowStart]; // subtract the element going out
//				windowStart++; // slide the window ahead
//			}
//		}
//
//		return maxSum;
//	}
//
//	public static void main(String[] args) {
//		System.out.println("Maximum sum of a subarray of size K: "
//				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
//		System.out.println("Maximum sum of a subarray of size K: "
//				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
//	}
}
