package com.algods.pattern.topk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a string and a number ‘K’, find if the string can be rearranged such that 
 * the same characters are at least ‘K’ distance apart from each other
 * @author tarin
 *
 */
public class RearrangeStringKDistanceApart {
	
	/**
	 * Time complexity O(N*logN)
	 * Space complexity O(N)
	 * @param str
	 * @param K
	 * @return
	 */
	public static String reorganizeString(String str, int K) {
		
		Map<Character, Integer> charMap = new HashMap<>();
		for(char c: str.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((n1,n2) -> n2.getValue() - n1.getValue() );
		maxHeap.addAll(charMap.entrySet());
		
		StringBuilder result = new StringBuilder();
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		
		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> currentEntry =  maxHeap.poll();
			
			result.append(currentEntry.getKey());
			currentEntry.setValue(currentEntry.getValue()-1);
			queue.offer(currentEntry);
			if(queue.size() == K) {
				Map.Entry<Character, Integer> entry = queue.poll();
				if(entry.getValue() > 0) {
					maxHeap.add(entry);
				}
			}
		}
		return (str.length() == result.toString().length() ? result.toString() : "");
	}
	
	public static void main(String[] args) {
	    System.out.println("Reorganized string: " + 
	              RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
	    System.out.println("Reorganized string: " + 
	              RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
	    System.out.println("Reorganized string: " + 
	              RearrangeStringKDistanceApart.reorganizeString("aab", 2));
	    System.out.println("Reorganized string: " + 
	              RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
	  }
}
