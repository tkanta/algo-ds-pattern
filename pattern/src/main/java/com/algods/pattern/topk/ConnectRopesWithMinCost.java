package com.algods.pattern.topk;

import java.util.PriorityQueue;

/**
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into
 * one big rope with minimum cost. The cost of connecting two ropes is equal to
 * the sum of their lengths. 
 * 
 * Time Complexity O(N*logN)
 * 
 * @author tarin
 *
 */
public class ConnectRopesWithMinCost {

	public static int minimumCostToConnectRopes(int[] ropeLengths) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2) -> n1-n2 );
		
		for(int i: ropeLengths) {
			minHeap.add(i);
		}
		
		int result = 0, temp = 0;
		
		while(minHeap.size() > 1) {
			temp = (minHeap.poll() + minHeap.poll());
			result += temp;
			minHeap.add(temp);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
	    int result = ConnectRopesWithMinCost.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
	    System.out.println("Minimum cost to connect ropes: " + result);
	    result = ConnectRopesWithMinCost.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
	    System.out.println("Minimum cost to connect ropes: " + result);
	    result = ConnectRopesWithMinCost.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
	    System.out.println("Minimum cost to connect ropes: " + result);
	  }
}
