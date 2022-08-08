package com.realworld.netflix.topmovies;

import java.util.ArrayList;
import java.util.List;

public class FetchTopMovies {

	public static LinkedListNode mergeMovieListPair(LinkedListNode l1, LinkedListNode l2) {
		
		LinkedListNode temp = new LinkedListNode(-1);
		
		LinkedListNode prev = temp;
		while(l1 != null && l2 != null) {
			
			if(l1.data < l2.data) {
				prev.next = l1;
				l1 = l1.next;
			}else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		
		if(l1 == null) {
			prev.next = l2;
		}else {
			prev.next = l1;
		}
		
		return temp.next;
	}
	
	
	public static LinkedListNode mergeMovieList(List<LinkedListNode> movies) {
		
		if(movies.size() > 0) {
			LinkedListNode res = movies.get(0);
			
			for(int i=1; i<movies.size(); i++) {
				res = mergeMovieListPair(res, movies.get(i));
			}
			
			return res;
		}
		return new LinkedListNode(-1);
	}
	
	public static void main(String[] args) {
		
		LinkedListNode a = LinkedList.createLinkedList(new int[] {11,41,51});
		LinkedListNode b = LinkedList.createLinkedList(new int[] {21,23,42});
		LinkedListNode c = LinkedList.createLinkedList(new int[] {25,56,66,72});
		
		List<LinkedListNode> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		
		LinkedListNode result = mergeMovieList(list);
		
		LinkedList.display(result);
		
	}
}
