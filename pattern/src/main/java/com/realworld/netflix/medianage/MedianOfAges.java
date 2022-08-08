package com.realworld.netflix.medianage;

import java.util.PriorityQueue;

public class MedianOfAges {
	PriorityQueue<Integer> smallList; //containing first half of numbers
	PriorityQueue<Integer> largeList; //containing second half of numbers

	  public MedianOfAges() {
	    smallList = new PriorityQueue<>((a, b) -> b - a);
	    largeList = new PriorityQueue<>((a, b) -> a - b);
	  }

	  public void insertNum(int num) {
	    if (smallList.isEmpty() || smallList.peek() >= num)
	      smallList.add(num);
	    else
	      largeList.add(num);

	    // either both the heaps will have equal number of elements or max-heap will have one 
	    // more element than the min-heap
	    if (smallList.size() > largeList.size() + 1)
	      largeList.add(smallList.poll());
	    else if (smallList.size() < largeList.size())
	      smallList.add(largeList.poll());
	  }

	  public double findMedian() {
	    if (smallList.size() == largeList.size()) {
	      // we have even number of elements, take the average of middle two elements
	      return smallList.peek() / 2.0 + largeList.peek() / 2.0;
	    }
	    // because max-heap will have one more element than the min-heap
	    return smallList.peek();
	  }

	  public static void main(String[] args) {
	    // Driver code
	    
	    MedianOfAges MedianOfAges = new MedianOfAges();
	    MedianOfAges.insertNum(22);
	    MedianOfAges.insertNum(35);
	    //System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
	    MedianOfAges.insertNum(30);
	    MedianOfAges.insertNum(34);
	    MedianOfAges.insertNum(36);
	    System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
	    //MedianOfAges.insertNum(25);
	    //System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
	  }
}
