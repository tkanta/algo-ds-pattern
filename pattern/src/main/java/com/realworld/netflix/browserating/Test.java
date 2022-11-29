package com.realworld.netflix.browserating;

public class Test {
	public static void main(String args[]) {

	    MaxStack stack = new MaxStack(7);
	    stack.push(5);
	    stack.push(0);
	    stack.push(2);
	    stack.push(4);
	    stack.push(6);
	    stack.push(3);
	    stack.push(10);

	    System.out.println("Maximum Rating: " + stack.maxRating());

	    stack.pop();
	    System.out.println("\nAfter clicking back button\n");

	    System.out.println("Maximum Rating: " + stack.maxRating()); 

	  }
}
