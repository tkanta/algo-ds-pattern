package com.algods.pattern.twopointers;

public class Palindrome {

	private static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() -1;
		
		while(left <= right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left+=1;
			right-=1;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String[] strs = new String[] {"kayak","hello","RACEACAR","A","ABCDABCD","DCBAABCD","ABCBA"};
		for(String s : strs) {
			System.out.println(s + " is palindrom ? "+ isPalindrome(s));
		}
	}
}
