package com.algods.pattern.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * O(N*logN) 
 * @author tarin
 *
 */
public class FrequencySort {

	public static String sortCharacterByFrequency(String str) {
		
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for(char c: str.toCharArray()) {
			charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(n1, n2) -> n2.getValue() - n1.getValue());
		
		
		maxHeap.addAll(charFrequencyMap.entrySet());
		
		StringBuilder sortedString = new StringBuilder();
		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for(int i=0; i<entry.getValue(); i++) {
				sortedString.append(entry.getKey());
			}
		}
		
		return sortedString.toString();
	}

	public static void main(String[] args) {
		String result = FrequencySort.sortCharacterByFrequency("Programming");
		System.out.println("Here is the given string after sorting characters by frequency: " + result);

		result = FrequencySort.sortCharacterByFrequency("abcbab");
		System.out.println("Here is the given string after sorting characters by frequency: " + result);
	}
}
