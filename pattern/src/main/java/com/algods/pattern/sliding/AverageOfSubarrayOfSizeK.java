package com.algods.pattern.sliding;

import java.util.Arrays;

/**
 * Given an array, find the average of all subarrays of ‘K’ contiguous elements in it.
 * @author tarin
 *
 */
public class AverageOfSubarrayOfSizeK {

	public static double[] findAverage(int K, int[] arr) {
		
		double[] result = new double[arr.length - K + 1];
		int windowStart = 0, windowSum = 0;
		
		for(int windowEnd=0; windowEnd < arr.length; windowEnd++) {
			
			windowSum += arr[windowEnd];
			
			if(windowEnd >= K-1) {
				result[windowStart] = windowSum;
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
		double[] result = findAverage(5, arr);
		System.out.println(Arrays.toString(result));
	}
}
