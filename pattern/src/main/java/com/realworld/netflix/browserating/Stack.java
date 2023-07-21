package com.realworld.netflix.browserating;

public class Stack<V> {
	
	private int maxSize;
	private int currentSize;
	private int top;
	private V[] array;
	
	@SuppressWarnings("unchecked")
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;
		this.currentSize = 0;
		array = (V[]) new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return this.top == (maxSize-1);
	}
	
	
	public V top() {
		if(isEmpty()) {
			return null;
		}
		return array[top];
	}
	
	public void push(V element) {
		if(isFull()) {
			System.err.println("Stack is full...");
			return;
		}
		array[++top] = element;
		this.currentSize++;
	}
	
	public V pop() {
		if(isEmpty()) {
			return null;
		}
		this.currentSize--;
		return array[top--];
	}
	
}
