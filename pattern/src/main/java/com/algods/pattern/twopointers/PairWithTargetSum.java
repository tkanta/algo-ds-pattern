package com.algods.pattern.twopointers;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array
 * whose sum is equal to the given target.
 * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
 * @author tarini
 *
 */
public class PairWithTargetSum {
	
	/**
	 * Self
	 * @param arr
	 * @param targetSum
	 * @return
	 */
	public static int[] search(int[] arr, int targetSum) {
	    for(int i=0,j=arr.length-1; i < j; ) {
	    	int sum = arr[i] + arr[j];
	    	if(sum == targetSum) {
	    		return new int[] {i , j};
	    	}else if(sum > targetSum) {
	    		j--;
	    	}else if(sum < targetSum) {
	    		i++;
	    	}
	    }
	    return new int[] { -1, -1 };
	  }
	
	/**
	 * Educative
	 * @param arr
	 * @param targetSum
	 * @return
	 */
	public static int[] eduSearch(int[] arr, int targetSum) {
	    int left = 0, right = arr.length - 1;
	    while (left < right) {
	      int currentSum = arr[left] + arr[right];
	      if (currentSum == targetSum)
	        return new int[] { left, right }; // found the pair

	      if (targetSum > currentSum)
	        left++; // we need a pair with a bigger sum
	      else
	        right--; // we need a pair with a smaller sum
	    }
	    return new int[] { -1, -1 };
	  }
	
	public static void main(String[] args) {
		int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
	    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	    result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
	    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	}
}
