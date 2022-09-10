package com.realworld.netflix.fetchrecently;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	int capacity;
	Map<Integer,LinkedListNode> cache;
	CustomDoublyLinkedList cacheVal;
	
	
	public LRUCache(int capacity) {
		cache = new HashMap<>(capacity);
		cacheVal = new CustomDoublyLinkedList();
		this.capacity = capacity;
	}
	
	void set(int key, int data) {
		if(!cache.containsKey(key)) {
			evictIfNeeded();
			cacheVal.insertAtTail(key, data);
			cache.put(key, cacheVal.getTail());
		}else {
			cacheVal.removeNode(cache.get(key));
			cacheVal.insertAtTail(key, data);
			cache.put(key, cacheVal.getTail());
		}
	}
	
	LinkedListNode get(int key) {
		if(!cache.containsKey(key)) {
			return null;
		}else {
			int data = cache.get(key).data;	
			cacheVal.removeNode(cache.get(key));
			cacheVal.insertAtTail(key, data);
			cache.put(key, cacheVal.getTail());
			return cacheVal.getTail();
		}
	}
	
	void print() {
		LinkedListNode curr = cacheVal.getHead();
		
		while(curr != null) {
			System.out.print("("+curr.key+","+curr.data+")");
			curr = curr.next;
		}
		System.out.println("");
	}
	
	
	void evictIfNeeded() {
		if(cacheVal.size >= capacity) {
			LinkedListNode node = cacheVal.removeHead();
			cache.remove(node.key);
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
	    System.out.println("The most recently watched titles are: (key, value)");
	    cache.set(10,20);
	    cache.print();

	    cache.set(15,25);
	    cache.print();

	    cache.set(20,30);
	    cache.print();

	    cache.set(25,35);
	    cache.print();

	    cache.set(5,40);
	    cache.print();

	    cache.get(25);
	    cache.print();
	}
}
