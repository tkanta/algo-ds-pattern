package com.realworld.netflix.PopularityAnalysis;

public class PopularityAnalysis {

	
	public static boolean identifyTitles(int[] scores) {
		
		boolean increasing = true;
		boolean decreasing = true;
		
		for(int i=0; i<scores.length-1; i++) {
			if(scores[i] > scores[i+1]) {
				increasing = false;
			}
			if (scores[i] < scores[i+1]) {
				decreasing = false;
			}
		}
		
		// if either of them is true, that is increasing/decreasing. If both are false that is fluctuating
		return (increasing || decreasing);
	}
	
	public static void main(String[] args) {
		
		int[][] movie_rating = {
				{1,2,2,3},
				{4,5,6,3,4},
				{8,8,7,6,5,4,4,1}
		};
		
		for(int[] score: movie_rating) {
			if(identifyTitles(score)) {
				System.out.println("Title identified and separated...");
			}else {
				System.out.println("Title score fluctuating...");
			}
		}
	}
}
