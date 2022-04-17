package com.algods.pattern.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAllDistinct {
	
	
	
	/**
	 * Self Solution
	 * @param str
	 * @return
	 */
	private static int findLongestOfAllDistinct(String str) {
		int maxLen = 0, distinctLength=0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int wEnd=0; wEnd < str.length(); wEnd++) {
			char c = str.charAt(wEnd);
			map.put(c, map.getOrDefault(c, 0)+1);
			
			//If duplicate character appear, start with distinct length from 1
			if(map.get(c) > 1) {
				map.clear();
				distinctLength = 1; 
			}else {
				++distinctLength; // contiguous distinct length
			}
			
			// remember contiguous max length till now
			maxLen = Math.max(maxLen, distinctLength);
		}
		
		return maxLen;
	}
	
	
	/**
	 * Educative Solution
	 * @param str
	 * @return
	 */
	public static int findLength(String str) {
	    int windowStart = 0, maxLength = 0;
	    Map<Character, Integer> charIndexMap = new HashMap<>();
	    // try to extend the range [windowStart, windowEnd]
	    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
	      char rightChar = str.charAt(windowEnd);
	      // if the map already contains the 'rightChar', shrink the window from the beginning so that
	      // we have only one occurrence of 'rightChar'
	      if (charIndexMap.containsKey(rightChar)) {
	        // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
	        // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
	        windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
	      }
	      charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
	      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
	    }

	    return maxLength;
	  }
	
	/**
	 * Test 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s = "aabccbb"; // "abccde"; // "abbbb"; // "ssdegrr"; // 
//		System.out.println("Length of the longest substring: " +findLongestOfAllDistinct("aabccbb"));
//		System.out.println("Length of the longest substring: " +findLongestOfAllDistinct("abbbb"));
		System.out.println("Length of the longest substring: " +findLongestOfAllDistinct("abccaadefg"));
		
		System.out.println("-----------------------");
		
//		System.out.println("Length of the longest substring: " + findLength("aabccbb"));
//	    System.out.println("Length of the longest substring: " + findLength("abbbb"));
	    System.out.println("Length of the longest substring: " + findLength("abccaadefg"));
	}
}
