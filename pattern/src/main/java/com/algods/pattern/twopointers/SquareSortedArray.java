package com.algods.pattern.twopointers;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * @author tarin
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
public class SquareSortedArray {

	
	public static int[] makeSquares(int[] arr) {
		int len = arr.length;
		int[] squares = new int[len];
		
		int left=0, right = len-1, sqrIndx=len-1;
		while(left <= right) {
			int leftSqr = arr[left] * arr[left];
			int rightSqr = arr[right] * arr[right];
			
			if(leftSqr > rightSqr) {
				squares[sqrIndx--] = leftSqr;
				left++;
			}else {
				squares[sqrIndx--] = rightSqr;
				right--;
			}
		}
		
		return squares;
	}
	
	public static void main(String[] args) {
		
		int[] result = SquareSortedArray.makeSquares(new int[] { -2, -1, 0, 2, 3 });
	    for (int num : result)
	      System.out.print(num + " ");
	    System.out.println();

	    result = SquareSortedArray.makeSquares(new int[] { -3, -1, 0, 1, 2 });
	    for (int num : result)
	      System.out.print(num + " ");
	    System.out.println();
	}
}
