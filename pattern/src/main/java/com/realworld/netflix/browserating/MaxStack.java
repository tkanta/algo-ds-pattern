package com.realworld.netflix.browserating;

/**
 * In this feature, the user will be able to randomly browse through movie
 * titles and read their summaries and reviews. We want to enable a Back button
 * so the user can return to the previous title in the viewing history. We also
 * want the user to immediately get the title with the highest viewer rating
 * from their viewing history.
 * 
 * @author tarin
 *
 */
public class MaxStack {
	int maxSize;
	Stack<Integer> maxStack;
	Stack<Integer> mainStack;
	
	public MaxStack(int maxSize) {
		this.maxSize = maxSize;
		maxStack = new Stack<Integer>(this.maxSize);
		mainStack = new Stack<Integer>(this.maxSize);
	}
	
	public int pop() {
		this.maxStack.pop();
		return this.mainStack.pop();
	}
	
	public void push(Integer val) {
		this.mainStack.push(val);
		
		if(!this.maxStack.isEmpty() && this.maxStack.top() > val) {
			this.maxStack.push(this.maxStack.top());
		}else {
			this.maxStack.push(val);
		}
	}
	
	public int maxRating() {
		return this.maxStack.top();
	}
}
