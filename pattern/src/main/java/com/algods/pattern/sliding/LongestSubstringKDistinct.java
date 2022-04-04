package com.algods.pattern.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * @author tarin
 *
 */
public class LongestSubstringKDistinct {
	
	private static int findLongSubStrDistinctK(String str, int K) {
		int windowStart=0, maxLength=0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(int windowEnd=0; windowEnd< str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			map.put(rightChar, map.getOrDefault(rightChar, 0)+1);
			
			// if size greater than distinct chars, increase windowStart pointer by removing chars from left
			while(map.size() > K) {
				char leftChar = str.charAt(windowStart);
				map.put(leftChar, map.get(leftChar)-1);
				if(map.get(leftChar) == 0) {
					map.remove(leftChar);
				}
				windowStart++;
			}
			
			maxLength = Math.max(maxLength, windowEnd-windowStart+1);
		}
		
		return maxLength;
	}
	public static void main(String[] args) {
		String str = "araaci"; 
		int res = findLongSubStrDistinctK(str, 2);
		System.out.println(res);
		//-----------------------------
		String str1 = "aaaaci"; 
		int res1 = findLongSubStrDistinctK(str1, 2);
		System.out.println(res1);
		//----------------
		String str2 = "cbbebi"; 
		int res2 = findLongSubStrDistinctK(str2, 3);
		System.out.println(res2);
	}
}
