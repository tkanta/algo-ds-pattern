package com.realworld.netflix.fetchrecently;

import java.util.HashMap;
import java.util.Map;

/**
 * A doubly linked list provides an ideal way of maintaining ordered elements.
 * We can keep the most recently accessed item at the tail. But when a recently
 * watched item is accessed again, we’ll move it to the tail of the linked list.
 * This will require searching for an element in the linked list, which is
 * expensive. To fix this, we can use a hash map to store the pointers of the
 * linked list elements.
 * 
 * Here’s how we implement the feature:
 * 
 * If the element exists in the hashmap, our first step is to move the accessed
 * element to the tail of the linked list.
 * 
 * If the data structure is at its capacity, remove the element at the head of
 * the linked list and the Hash Map. Then, we add the new element at the tail of
 * the linked list and in the Hash Map.
 * 
 * Finally, we retrieve the element and return.
 * 
 * @author tarin
 *
 */
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
