package com.realworld.netflix.fetchfrequently;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feature #6: Fetch Most Frequently Watched Titles
 * @author tarin
 * Summary:
 * 1. keyDict to store saved node reference
 * 2. freqDict to store nodes queue with frequency
 * 3. minFreq is used to delete node when size is more than capacity
 *
 */
class LFUCache2 {
	int capacity;
	int size;
	int minFreq;
	// LinkedListNode holds key and value pairs
	HashMap<Integer, LinkedListNode> keyDict;

	HashMap<Integer, MyLinkedList> freqDict;

	public LFUCache2(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.minFreq = 0;
		keyDict = new HashMap<Integer, LinkedListNode>(capacity);
		freqDict = new HashMap<Integer, MyLinkedList>(capacity);
	}

	LinkedListNode Get(int key) {
		if (!keyDict.containsKey(key)) {
			return null;
		}
		
		//delete node from queue in freqDict
		LinkedListNode temp = this.keyDict.get(key);
		this.freqDict.get(temp.freq).deleteNode(temp);
		
		//delete entry from map if no node present in the queue and increase minFreq
		if (this.freqDict.get(this.keyDict.get(key).freq).head == null) {
			this.freqDict.remove(this.keyDict.get(key).freq);
			if (this.minFreq == this.keyDict.get(key).freq) {
				this.minFreq += 1;
			}
		}
		
		//update frequency
		this.keyDict.get(key).freq += 1;
		
		//add node with new/existing key
		if (!this.freqDict.containsKey(this.keyDict.get(key).freq)) {
			this.freqDict.put(this.keyDict.get(key).freq, new MyLinkedList());
		}
		this.freqDict.get(this.keyDict.get(key).freq).append(this.keyDict.get(key));
		return this.keyDict.get(key);
	}

	void Set(int key, int value) {
		if (this.Get(key) != null) {
			this.keyDict.get(key).val = value;
			return;
		}
		
		//evict when size is more than capacity
		if (this.size == this.capacity) {
			this.keyDict.remove(this.freqDict.get(this.minFreq).head.key);
			this.freqDict.get(this.minFreq).deleteNode(this.freqDict.get(this.minFreq).head);
			if (this.freqDict.get(this.minFreq).head == null) {
				this.freqDict.remove(this.minFreq);
			}
			this.size -= 1;
		}
		
		// Add new element
		this.minFreq = 1;
		this.keyDict.put(key, new LinkedListNode(key, value, this.minFreq));
		if (!this.freqDict.containsKey(this.keyDict.get(key).freq)) {
			this.freqDict.put(this.keyDict.get(key).freq, new MyLinkedList());
		}
		this.freqDict.get(this.keyDict.get(key).freq).append(this.keyDict.get(key));
		this.size++;
	}

	void print() {
		for (Map.Entry<Integer, LinkedListNode> entry : keyDict.entrySet()) {
			System.out.print("(" + entry.getKey() + ", " + entry.getValue().val + ")");
		}
		System.out.println("");
	}
    
	/**
	 * Iterate from high to low frequency
	 */
	void printMostFrequently() {
		List<Integer> sortedList = new ArrayList<>(this.freqDict.keySet());
		Collections.sort(sortedList, Collections.reverseOrder());
		sortedList.forEach(i -> {
			LinkedListNode temp = freqDict.get(i).head;
			while(temp != null) {
				System.out.println("key:"+temp.key +" -> value:"+temp.val+", freq:"+temp.freq);
				temp = temp.next;
			}
		});
		
	}
	public static void main(String[] args) {
		LFUCache2 cache = new LFUCache2(4);
		System.out.print("The most frequently watched titles are: (key, value)\n");
		cache.Set(1, 1);
		cache.Set(2, 2);
		//cache.print();
		cache.Get(1);
		cache.Get(1);
		cache.Set(3, 3);
		cache.Get(2);
		cache.Get(2);
		cache.Set(4, 4);
		cache.Get(4);
		cache.Get(4);
		cache.Set(5, 5);
		//cache.print();
		cache.printMostFrequently();

	}
}