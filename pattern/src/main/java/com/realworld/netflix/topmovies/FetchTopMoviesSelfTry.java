package com.realworld.netflix.topmovies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FetchTopMoviesSelfTry {
	
	public static LinkedList<Integer> mergeMovie(LinkedList l1, LinkedList l2) {
		
		LinkedList<Integer> merge = new LinkedList<>();
		
		while(l1 != null && l2 != null) {
		}
		
		return merge;
	}
	
	public static LinkedList<Integer> mergeTopMovieList(List<LinkedList> list) {
		
		if(list.size() > 0) {
			LinkedList<Integer> result = list.get(0);
			
			for(int i=1; i<list.size(); i++) {
				result = mergeMovie(result, list.get(i));
			}
			return result;
		}
		
		return new LinkedList<>();
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(11,41,51));
		LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(21,23,42));
		LinkedList<Integer> l3 = new LinkedList<>(Arrays.asList(25,56,66,72));
		
		List<LinkedList> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		
	}
}
