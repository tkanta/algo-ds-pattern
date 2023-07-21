package com.algods.pattern.twopointers;

public class TripletSumCloseToTarget {

	public static int searchTriplets(int[] arr, int targetSum) {
		
		if(arr == null || arr.length < 3) {
			throw new IllegalArgumentException("array size is less than 3");
		}
		
		//List<List<Integer>> triplets = new ArrayList<>();
		int smallestDiff = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length - 2; i++) {
			
			int left = i+1, right = arr.length-1;
			while(left < right) {
				
				int targetDiff = targetSum - (arr[i] + arr[left] + arr[right]);
				
				if(targetDiff == 0) {
					return targetSum;
				}
				
//				if (smallestDiff != Integer.MAX_VALUE && targetDiff < smallestDiff && targetDiff < targetSum  ) {
//					smallestDiff = targetDiff;
//				}else if(smallestDiff == Integer.MAX_VALUE && targetDiff < targetSum) {
//					smallestDiff = targetDiff;
//				}
						
				if ( Math.abs(targetDiff) < Math.abs(smallestDiff)
			            || 
			       (Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff) ) {
					smallestDiff = targetDiff;
				}
				
				if(targetDiff > 0 ) {
					left++;
				}else {
					right--;
				}
				
			}
		}
		return targetSum - smallestDiff;
	}
	
	public static void main(String[] args) {
		System.out.println(TripletSumCloseToTarget.searchTriplets(new int[] { -2, 0, 1, 2 }, 2));
	    System.out.println(TripletSumCloseToTarget.searchTriplets(new int[] { -3, -1, 1, 2 }, 1));
	    System.out.println(TripletSumCloseToTarget.searchTriplets(new int[] { 1, 0, 1, 1 }, 100));
	}
}
