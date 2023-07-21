package com.algods.pattern.twopointers;

import java.util.Arrays;

public class TripletSumToTarget {
	
	public static boolean findSumOfThree(int nums[], int target) {
		// Sorting the input list
		Arrays.sort(nums);
		int low, high, triples;

		// Fix one element at a time and find the other two
		// Here nums.length - 2 because, in last iteration last two number needed for triplets
		for (int i = 0; i < nums.length - 2; i++) {
			// Set the indexes of the two pointers

			// Index of the first of the remaining elements
			low = i + 1;

			// Last index
			high = nums.length - 1;

			while (low < high) {
				// Check if the sum of the triple is equal to the sum
				triples = nums[i] + nums[low] + nums[high];
				// Found a triple whose sum equals the target
				if (triples == target) {
					return true;
				}
				// Move low pointer forward if the triple sum is less
				// than the required sum
				else if (triples < target) {
					low++;
				} // Move the high pointer backwards if the triple
					// sum is greater than the required sum
				else {
					high--;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
                       {-1, 2, 1, -4, 5, -3},
                       {2, 3, 4, 1, 7, 9},
                       {1, -1, 0},
                       {2, 4, 2, 7, 6, 3, 1}};
					   
		int[][] testList = {{10, 20, 21},
                         {-8, 0, 7},
                         {8, 10, 20},
                         {1, -1, 0},
                         {8, 11, 15}};

		
		for (int i=0; i<testList.length; i++) {
			System.out.print(i+1);
			System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));
			for(int j=0 ;j<testList[i].length; j++){
              if (findSumOfThree(numsList[i], testList[i][j])) {
				System.out.println("\tSum for " + testList[i][j] + " exists ");
			  } else {
				System.out.println("\tSum for " + testList[i][j] + " does not exist ");
			  }
			}
		}
		
	}
}
