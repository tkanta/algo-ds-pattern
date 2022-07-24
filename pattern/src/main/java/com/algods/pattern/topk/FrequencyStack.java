package com.algods.pattern.topk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Design a class that simulates a Stack data structure, implementing the following two operations:
	push(int num): Pushes the number ‘num’ on the stack.
	pop(): Returns the most frequent number in the stack. If there is a tie, return the number which was pushed later.
 * @author tarin
 *
 */


class Element{
	int number;
	int frequency;
	int sequenceNo;
	
	public Element(int num, int freq, int seq) {
		this.number = num;
		this.frequency = freq;
		this.sequenceNo = seq;
	}
}

class ElementComparator implements Comparator<Element>{
	public int compare(Element e1, Element e2) {
		if(e1.frequency != e2.frequency) {
			return e2.frequency - e1.frequency;
		}
		
		return e2.sequenceNo - e1.sequenceNo;
	}
}

public class FrequencyStack {

	
	int sequenceNo = 0;
	PriorityQueue<Element> maxHeap = new PriorityQueue<>(new ElementComparator());
	Map<Integer, Integer> frequencyMap = new HashMap<>();
	
	public void push(int num) {
		frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
		maxHeap.offer(new Element(num, frequencyMap.get(num), sequenceNo++));
	}
	
	public int pop() {
		int num = maxHeap.poll().number;
		
		if(frequencyMap.get(num) > 1) {
			frequencyMap.put(num, frequencyMap.get(num)-1);
		}else {
			frequencyMap.remove(num);
		}
		return num;
	}
	
	public static void main(String[] args) {
	    FrequencyStack frequencyStack = new FrequencyStack();
	    frequencyStack.push(1);
	    frequencyStack.push(2);
	    frequencyStack.push(3);
	    frequencyStack.push(2);
	    frequencyStack.push(1);
	    frequencyStack.push(2);
	    frequencyStack.push(5);
	    System.out.println(frequencyStack.pop());
	    System.out.println(frequencyStack.pop());
	    System.out.println(frequencyStack.pop());
	    System.out.println(frequencyStack.pop());
	    System.out.println(frequencyStack.pop());
	    System.out.println(frequencyStack.pop());
	    System.out.println(frequencyStack.pop());
	  }
	
}
